package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(version = "Differ version 0.1", header = "DifferHeader",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true)
public class App implements Callable <Integer> {

    @Option(names = {"-h", "--help"}, usageHelp = true,
            description = "Print usage help and exit.")
    boolean usageHelpRequested;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format = "stylish";

    @Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionHelpRequested;
    @Parameters(paramLabel = "filepath1", defaultValue = "./",
            description = "Path for file one")
    private String pathOne = "./";
    @Parameters(paramLabel = "filepath2", defaultValue = "./",
            description = "Path for file two")
    private String pathTwo = "./";

    @Override
    public Integer call() throws Exception {
        Differ.generate();
        return 0;
    }

    public static void main(String... args) {
        new CommandLine(new App()).execute(args);
    }


}




