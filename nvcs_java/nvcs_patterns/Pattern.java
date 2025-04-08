package nvcs_java.nvcs_patterns;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    public List<String> pattern = new ArrayList<>();
    public boolean negated;
    
    public Pattern(String expr) {
        if (expr == null) {
            throw new RuntimeException("Pattern is empty");
        }
        else {
            String cleanedExpr = expr.replaceAll("^\\s+", "");
            negated = cleanedExpr.startsWith(("!"));
            for (String splitExpr : cleanedExpr.split(",")) {
                String stripped = splitExpr.trim();
                pattern.add(stripped);
            }
        }
    }

    public boolean match(String value) {
        if (negated) {
            return !pattern.contains(value);
        }
        else {
            return pattern.contains(value);
        }
    }

    @Override
    public String toString() {
        return String.format("Pattern(%s, %s)", negated ? "!" : " ", pattern);
    }

}
