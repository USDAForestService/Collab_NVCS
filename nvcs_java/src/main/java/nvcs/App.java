package nvcs;

import nvcs_components.Classifier;
import nvcs_components.Node;
import nvcs_components.Plot;
import nvcs_components.Solution;
import nvcs_components.Tree;

public class App 
{
    public static void main( String[] args )
    {
        String type = args[0];

        Classifier classifier;
        if (type.equals("west")) {
            classifier = new Classifier(new ClassificationKeyWest());
        }
        else {
            classifier = new Classifier(new ClassificationKeyEast());
        }
        
        String ident = args[1];
        String rscd = args[2];
        String stateab = args[3];
        String ecoregion = args[4];
        String plantation = args[5];
        String hydric = args[6];
        String riverine = args[7];
        String elevation = args[8];
        String balive = args[9];
        String fbcov = args[10];
        String grcov = args[11];
        String shcov = args[12];
        String ttcov = args[13];
        String ntcov = args[14];
        Plot plot = new Plot(ident, rscd, stateab, ecoregion, plantation, hydric, riverine, elevation, balive, fbcov, grcov, shcov, ttcov, ntcov);

        for (int i = 15; i < args.length - 1; i += 23) {
            String species = args[i];
            String riv = args[i + 1];
            String wetland = args[i + 2];
            String ruderal = args[i + 3];
            String exotic = args[i + 4];
            String softwoodhardwood = args[i + 5];
            String planted = args[i + 6];
            String tallytree = args[i + 7];
            String spcov = args[i + 8];
            Tree tree = new Tree(species, riv, wetland, ruderal, exotic, softwoodhardwood, planted, tallytree, spcov);
            plot.trees.add(tree);
        }

        Solution solution = classifier.classify(plot);
        Node finalNode = solution.path.get(solution.path.size() - 1);
        Integer nodeId = finalNode != null ? finalNode.ident : -1;
        System.out.println(nodeId);
        //return finalNode.ident;
    }
}
