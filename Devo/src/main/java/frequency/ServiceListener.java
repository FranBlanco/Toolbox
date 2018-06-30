package frequency;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;

public class ServiceListener {

    private String path;
    private String word;
    private long miliseconds;
    private int top ;

    private static final Logger LOGGER = Logger.getLogger( ServiceListener.class.getName() );


    public ServiceListener(String path, int top, String word, long miliseconds) {

        this.path = path;
        this.top = top;
        this.word = word;
        this.miliseconds = System.currentTimeMillis() + miliseconds;

    }

    public static Map<String,Double> files = new HashMap<>();

    public static Object lockMap = new Object();

    public static float total = 0;

    public static long totalFilesWithFrequency = 0;

    public static void updateIndicators(String name, double frequency, long num){
        if(files.get(name) != null ) {
            return ;
        }
        synchronized (lockMap){
            files.put(name,frequency);
            total+=num;
            totalFilesWithFrequency++;
        }
    }

    public void run() throws InterruptedException {

        File folder = new File(path);

        List<Thread> threads = new ArrayList<>();
        while(System.currentTimeMillis() < miliseconds){

            Thread.sleep(1000);

            File[] files =  folder.listFiles();

            List<Thread> finalThreads = threads;
            Arrays.stream(files).forEach(p-> finalThreads.add(new ThreadParser(word,p)));

        }

        LOGGER.log(Level.FINE,("\n\nWaiting until all threads will finish....\n\n"));

        waitForThreads(threads);

        threads = calculateResults();

        waitForThreads(threads);

        printResults();

    }

    public static void write(String fileName, double calculate) {
        files.replace(fileName,calculate);
    }

    private void waitForThreads(List<Thread> threads) {
        threads.forEach(p -> {
            try {
                p.join();
            } catch (InterruptedException e) {
                LOGGER.log(Level.FINER,"Error thread has been killed");
			}
        });
    }

    private List<Thread> calculateResults() {
        List<Thread> threads = new ArrayList<>();

        files.forEach((k,v)->threads.add(new ThreadCalculator(k,v)));

        return threads;
    }


    private void printResults() {
        files.entrySet().stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .limit(top)
                .collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()))
                .forEach((k,v)->System.out.println(k+"-"+v));

    }


}
