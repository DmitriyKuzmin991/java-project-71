package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;


@Command(name = "getDiff", version = "Differ version 0.9",
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
    @Parameters(paramLabel = "filepath1", defaultValue = "file1.json",
            description = "Path for file one")
    private String pathOne = "";
    @Parameters(paramLabel = "filepath2", defaultValue = "file2.json",
            description = "Path for file two")
    private String pathTwo = "";

    @Override
    public Integer call() {
        Map<String, Object> resultParseFirstFile = null;
        Map<String, Object> resultParseSecondFile = null;
        try {
            resultParseFirstFile = parseJson(pathOne);
            resultParseSecondFile = parseJson(pathTwo);
        } catch (IOException e) {
            System.out.println("Ошибка попробуйте ещё");
            throw new RuntimeException(e);
        }
        String resultDiff = Differ.generate(resultParseFirstFile, resultParseSecondFile);
        System.out.println(resultDiff);
        return 0;
    }

    public static void main(String... args) {
        new CommandLine(new App()).execute(args);
    }


    public static Map<String, Object> parseJson(String filePath) throws IOException {
        File file = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(file, new TypeReference<Map<String,Object>>(){});
        return map;
    }


}




