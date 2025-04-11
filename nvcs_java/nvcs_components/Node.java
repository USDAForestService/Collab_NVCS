package nvcs_java.nvcs_components;

import java.util.ArrayList;
import java.util.List;

import nvcs_java.nvcs_interfaces.NodeMatch;

public class Node {
    
    public Integer ident;
    public Integer parent;
    public Integer level;
    public Integer code;
    public NodeMatch nodeMatch;
    public String description;
    public List<Node> children;

    public Node(Integer ident, Integer parent, Object[] config, String description) {
        this.ident = ident;
        this.parent = parent;
        this.level = (Integer)config[0];
        this.code = (Integer)config[1];
        this.nodeMatch = (NodeMatch)config[2];
        this.description = description;
        this.children = new ArrayList<>();
    }

    public boolean match_function(Plot plot) {
        return nodeMatch.match(plot);
    }

    @Override
    public String toString() {
        return String.format("Node(%s, %s, %s, %s)", ident, parent, "match_function", description);
    }
}
