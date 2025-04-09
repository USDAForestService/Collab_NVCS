package nvcs_java.nvcs_components;

import java.util.List;

public class Solution {
    
    private Object obj;
    private List<Node> path; 

    public Solution(Object obj, List<Node> path) {
        this.obj = obj;
        this.path = path;
    }

    @Override
    public String toString() {
        return String.format("Solution(%s, %s)", obj, path);
    }
}
