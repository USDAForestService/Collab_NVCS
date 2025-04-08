package nvcs_java.nvcs_components;

import java.util.ArrayList;
import java.util.List;

public class Classifier {

    private Node root_node;

    public Classifier(Node key) {
        root_node = key;
    }

    @Override
    public String toString() {
        return String.format("Classifier(%s)", root_node);
    }

    public Node choose(List<Node> nodes, Object obj) {
        for (Node node: nodes) {
            if (node.match_function(obj)) {
                return node;
            }
        }
        return null;
    }

    // public Object walk(Object root_node, Object obj) {
    //     Object node = root_node;
    //     while (node != null && node.children != null) {
    //         node = choose(node.children, obj);
    //         return node;
    //     }
    // }

    public Solution classify(Object obj) {
        List<Node> path = new ArrayList<>();
        Node node = root_node;
        while (node != null && node.children != null) {
            node = choose(node.children, obj);
            path.add(node);
        }
        return new Solution(obj, path);
    }
}
