package nvcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestApp {

    public static void main(String[] args) {
        String type = args[0];
        String inputPath = args[1];
        String outputPath = args[2];
        List<String> outputLines = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {
            stream.forEach(inLine -> {
                String[] split = inLine.split("\t");
                String ident = split[0];
                String json = split[1];
                Integer[] path = App.nvcs_classify(type, json);
                Integer solution = path.length > 0 ? path[path.length - 1] : -1;
                if (path[path.length - 1] == -1)
                    path = Arrays.copyOf(path, path.length - 1);

                String joinedPath = Stream.of(path).map(String::valueOf).collect(Collectors.joining(", "));
                String outputLine = String.format("%s\t%s\t[%s]", ident, solution, joinedPath);
                outputLines.add(outputLine);
            });
        }
        catch (IOException ex) {
            System.err.println("Error reading file: " + ex);
        }

        try {
            Files.write(Paths.get(outputPath), outputLines);
        }
        catch (Exception ex) {
            System.err.println("Error writing file: " + ex);
        }
    }
    
}