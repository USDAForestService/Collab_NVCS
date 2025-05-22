package nvcs;

import java.util.TreeMap;

import nvcs_components.Classifier;
import nvcs_components.Node;
import nvcs_components.Plot;
import nvcs_components.Solution;
import nvcs_components.Tree;
import nvcs_utilities.JsonParse;

public class App 
{

    public static String nvcs_classify(String type, String json) {
        Classifier classifier = getClassifierByType(type);
        Integer[] path = classify(classifier, json);
        Integer classification = path.length > 0 ? path[path.length-1] : -1;
        String returnJson = JsonParse.OutputToJson(classification, path);
        return returnJson;
    }

    private static Classifier getClassifierByType(String type) throws IllegalArgumentException {
        if (type.equals("west")) {
            return new Classifier(new ClassificationKeyWest()); 
        }
        else if (type.equals("east")) {
            return new Classifier(new ClassificationKeyEast());
        }
        else {
            throw new IllegalArgumentException("Invalid type provided");
        }
    }

    private static Integer[] classify(Classifier classifier, String json) {
        JsonParse jsonParse = new JsonParse(json);
        
        TreeMap<String,String> firstJsonRow = jsonParse.rows.get(0);
        Plot plot = new Plot(
            firstJsonRow.get("IDENT"),
            firstJsonRow.get("RSCD"),
            firstJsonRow.get("STATEAB"),
            firstJsonRow.get("ECOREGION"),
            firstJsonRow.get("PLANTATION"),
            firstJsonRow.get("HYDRIC"),
            firstJsonRow.get("RIVERINE"),
            firstJsonRow.get("ELEVATION"),
            firstJsonRow.get("BALIVE"),
            firstJsonRow.get("FBCOV"),
            firstJsonRow.get("GRCOV"),
            firstJsonRow.get("SHCOV"),
            firstJsonRow.get("TTCOV"),
            firstJsonRow.get("NTCOV")
        );

        for (TreeMap<String,String> jsonRow : jsonParse.rows) {
            Tree tree = new Tree(
                jsonRow.get("SPECIES"),
                jsonRow.get("RIV"),
                jsonRow.get("WETLAND"),
                jsonRow.get("RUDERAL"),
                jsonRow.get("EXOTIC"),
                jsonRow.get("SOFTWOODHARDWOOD"),
                jsonRow.get("PLANTED"),
                jsonRow.get("TALLYTREE"),
                jsonRow.get("SPCOV")
            );
            plot.trees.add(tree);
        }
        
        Solution solution = classifier.classify(plot);
        Integer[] path = new Integer[solution.path.size()];
        for (int i = 0; i < path.length; i++) {
            Node node = solution.path.get(i);
            path[i] = node != null ? node.ident : -1;
        }
        return path;
    }
}
