package nvcs_java.nvcs_components;

import java.util.ArrayList;
import java.util.List;

import nvcs_java.nvcs_interfaces.NodeMatch;

public class Node {
    
    public Integer ident;
    public Integer parent;
    public Integer level;
    public Integer code;
    public NodeMatch match_function;
    public String description;
    public List<Node> children;

    public Node(Integer ident, Integer parent, Object[] config, String description) {
        this.ident = ident;
        this.parent = parent;
        this.level = (Integer)config[0];
        this.code = (Integer)config[1];
        this.match_function = (NodeMatch)config[2];
        this.description = description;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Node(%s, %s, %s, %s)", ident, parent, "match_function", description);
    }
}
