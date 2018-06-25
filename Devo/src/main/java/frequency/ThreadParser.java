package frequency;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ThreadParser extends  Thread  {

    private String word;
    private File fileName;


    public ThreadParser(String word, File fileName) {

        this.word= word;

        this.fileName = fileName;

        start();
    }

    @Override
    public void run() {

        if (fileName.isDirectory() || ServiceListener.files.get(fileName.getName()) != null) {

            return;
        }
        Supplier<Stream<String>> sup = () -> {
            try {
                return Files.lines(Paths.get(fileName.getAbsolutePath()));
            } catch (IOException e) {
                throw new RuntimeException("File not found, It's a trap :)");
            }
        };

        System.out.println("Reading new file in directory "+fileName.getName());

        ServiceListener.updateIndicators(fileName.getName(), sup.get().filter(p -> word.equals(p)).count());
    }

}
