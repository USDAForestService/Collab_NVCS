package nvcs_components;

import java.util.ArrayList;
import java.util.List;

public class Classifier {

    public Node root_node;

    public Classifier(ClassificationKey key) {
        root_node = key.root_node;
    }

    @Override
    public String toString() {
        return String.format("Classifier(%s)", root_node);
    }

    public Node choose(List<Node> nodes, Plot obj) {
        for (Node node: nodes) {
            if (node.match_function(obj)) {
                return node;
            }
        }
        return null;
    }

    public Solution classify(Plot obj) {
        List<Node> path = new ArrayList<>();
        Node node = root_node;
        while (node != null && node.children != null && node.children.size() > 0) {
            node = choose(node.children, obj);
            path.add(node);
        }
        return new Solution(obj, path);
    }
}
