package frequency;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ThreadParser extends  Thread  {

    private String word;
    private File fileName;

    private static final Logger LOGGER = Logger.getLogger( ThreadParser.class.getName() );



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


        Supplier<Stream<String>> sup = this.getStreamSupplier(fileName.getAbsolutePath());

        LOGGER.log(Level.FINE,"Reading new file in directory {}",fileName.getName());

        ServiceListener.updateIndicators(fileName.getName(), sup.get().filter(p -> word.equals(p)).count(),sup.get().count());
    }

    public Supplier<Stream<String>> getStreamSupplier(String path) {

        return () -> {
            try {
                return Files.lines(Paths.get(path));
            } catch (IOException e) {
                throw new RuntimeException("File not found, It's a trap :)");
            }
        };
    }

}
