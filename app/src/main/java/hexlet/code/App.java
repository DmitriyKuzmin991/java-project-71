package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(version = "Differ version 0.1", header = "DifferHeader",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true)
public class App implements Runnable {

    @Option(names = {"-h", "--help"}, usageHelp = true,
            description = "Print usage help and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionHelpRequested;

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Hello world");
        }
    }


    public static void main(String... args) {
        new CommandLine(new App()).execute(args);
    }
}


