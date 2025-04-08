import java.util.ArrayList;
import java.util.List;

public class Classifier {

    private Object root_node;

    public Classifier(Object key) {
        root_node = key;
    }

    @Override
    public String toString() {
        return String.format("Classifier(%s)", root_node);
    }

    public Object choose(Object[] nodes, Object obj) {
        for (Object node: nodes) {
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
        List<Object> path = new ArrayList<>();
        Object node = root_node;
        while (node != null && node.children != null) {
            node = choose(node.children, obj);
            path.add(node);
        }
        return Solution(obj, path);
    }
}
