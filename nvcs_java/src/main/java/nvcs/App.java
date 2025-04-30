package nvcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nvcs_components.Classifier;
import nvcs_components.Node;
import nvcs_components.Plot;
import nvcs_components.Solution;
import nvcs_components.Tree;
import nvcs_utilities.JsonParse;
import nvcs_utilities.JsonRow;

public class App 
{
    public static void main(String[] args) {
        String inputPath = args[0];
        String outputPath = args[1];
        List<String> outputLines = new ArrayList<>();
        Classifier classifier = new Classifier(new ClassificationKeyWest());

        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {
            stream.forEach(inLine -> {
                String[] split = inLine.split("\t");
                String ident = split[0];
                String json = split[1];
                Integer[] path = classify(classifier, json);
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

    public static Integer[] classifyWest(String json) {
        Classifier classifier = new Classifier(new ClassificationKeyWest());
        return classify(classifier, json);
    }

    public static Integer[] classifyEast(String json) {
        Classifier classifier = new Classifier(new ClassificationKeyEast());
        return classify(classifier, json);
    }

    private static Integer[] classify(Classifier classifier, String json) {
        JsonParse jsonParse = new JsonParse(json);
        
        JsonRow firstJsonRow = jsonParse.rows.get(0);
        Plot plot = new Plot(
            firstJsonRow.IDENT,
            firstJsonRow.RSCD,
            firstJsonRow.STATEAB,
            firstJsonRow.ECOREGION,
            firstJsonRow.PLANTATION,
            firstJsonRow.HYDRIC,
            firstJsonRow.RIVERINE,
            firstJsonRow.ELEVATION,
            firstJsonRow.BALIVE,
            firstJsonRow.FBCOV,
            firstJsonRow.GRCOV,
            firstJsonRow.SHCOV,
            firstJsonRow.TTCOV,
            firstJsonRow.NTCOV
        );

        for (JsonRow jsonRow : jsonParse.rows) {
            Tree tree = new Tree(
                jsonRow.SPECIES,
                jsonRow.RIV,
                jsonRow.WETLAND,
                jsonRow.RUDERAL,
                jsonRow.EXOTIC,
                jsonRow.SOFTWOODHARDWOOD,
                jsonRow.PLANTED,
                jsonRow.TALLYTREE,
                jsonRow.SPCOV
            );
            plot.trees.add(tree);
        }
        
        Solution solution = classifier.classify(plot);
        Integer[] path = new Integer[solution.path.size()];
        for (int i = 0; i < path.length; i++) {
            Node node = solution.path.get(i);
            Integer ident = -1;
            if (node != null)
                ident = node.ident;
            path[i] = ident;
        }
        return path;
    }
}
