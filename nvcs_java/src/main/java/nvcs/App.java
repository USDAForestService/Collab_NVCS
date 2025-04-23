package nvcs;

import nvcs_components.Classifier;
import nvcs_components.Node;
import nvcs_components.Plot;
import nvcs_components.Solution;
import nvcs_components.Tree;
import nvcs_utilities.JsonParse;
import nvcs_utilities.JsonRow;

public class App 
{

    public static Integer classifyWest(String json) {
        Classifier classifier = new Classifier(new ClassificationKeyWest());
        return classify(classifier, json);
    }

    public static Integer classifyEast(String json) {
        Classifier classifier = new Classifier(new ClassificationKeyEast());
        return classify(classifier, json);
    }

    private static Integer classify(Classifier classifier, String json) {
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
        Node finalNode = solution.path.get(solution.path.size() - 1);
        Integer classification = finalNode != null ? finalNode.ident : -1;
        return classification;
    }
}
