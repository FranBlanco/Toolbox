package frequency;

import org.apache.commons.cli.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TermFrequencyApplication {

    private static String path;
    private static String word;
    private static int top;
    private static long miliseconds;
    private static final Logger LOGGER = Logger.getLogger( TermFrequencyApplication.class.getName() );

    private static Options options = new Options();
    static{
        options.addOption("d", "directory", true, "Directory to be examinated");
        options.addOption("n", "number", true, "Number of file to be showed");
        options.addOption("p", "processTime", true, "Time in miliseconds to be scanned");
        options.addOption("t", "term", true, "Term to be scanned");
    }


    public static void main(String... args) throws InterruptedException, ParseException {
        if (args.length < 8) {
            LOGGER.log(Level.FINE,"Invalid number of arguments");
            LOGGER.log(Level.FINE,"Example: -d test -n 3 -p 10000 -t hola");
            return;
        }
        readArguments(args);
        new ServiceListener(path, top, word, miliseconds).run();
    }

    private static void readArguments(String[] args) throws ParseException {

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        path = cmd.getOptionValue("directory");
        miliseconds = Long.valueOf(cmd.getOptionValue("processTime"));
        top = Integer.valueOf(cmd.getOptionValue("number"));
        word = cmd.getOptionValue("term");
    }
}