package nvcs_java.nvcs_components;

import java.util.ArrayList;
import java.util.List;

public class Node {
    
    public String ident;
    public Node parent;
    public int level;
    public int code;
    // match_function declaration
    public String description;
    public List<Node> children;

    public Node(String ident, Node parent, Object[] config, String description) {
        this.ident = ident;
        this.parent = parent;
        this.level = (int)config[0];
        this.code = (int)config[1];
        //this.match_function = config[2];
        this.description = description;
        this.children = new ArrayList<>();
    }
}
