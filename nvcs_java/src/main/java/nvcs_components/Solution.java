package nvcs_components;

import java.util.List;

public class Solution {
    
    public Plot obj;
    public List<Node> path; 

    public Solution(Plot obj, List<Node> path) {
        this.obj = obj;
        this.path = path;
    }

    @Override
    public String toString() {
        return String.format("Solution(%s, %s)", obj, path);
    }
}
