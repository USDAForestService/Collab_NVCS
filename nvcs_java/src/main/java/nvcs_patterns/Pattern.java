package nvcs_patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pattern {

    public static Map<String,String> attrpatts = new HashMap<>();
    public List<String> pattern;
    public boolean negated;
    
    public static void register(String attr, String pattcls) {
        attrpatts.put(attr, pattcls);
    }

    public Pattern(String expr) {
        if (expr == null) {
            throw new RuntimeException("Pattern is empty");
        }
        else {
            String cleanedExpr = expr.replaceAll("^\\s+", "");
            negated = cleanedExpr.startsWith("!");
            pattern = new ArrayList<>();
            for (String splitExpr : cleanedExpr.replace("!", "").split(",")) {
                String stripped = splitExpr.trim();
                pattern.add(stripped);
            }
        }
    }

    public boolean match(Object value) {
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
