package nvcs_java.nvcs_patterns;

import java.util.ArrayList;
import java.util.List;

public class _EcoregionPattern extends Pattern {
    
    public List<String> includepattern;
    public List<String> excludepattern;

    public _EcoregionPattern(String expr) {
        super(expr);
        if (expr == null) {
            throw new RuntimeException("Pattern is empty");
        }
        else {
            String cleanedExpr = expr.replaceAll("^\\s+", "");
            int p = cleanedExpr.indexOf("!");
            if (p == -1) {
                includepattern = new ArrayList<>();
                for (String splitExpr : cleanedExpr.split(",")) {
                    String stripped = splitExpr.trim();
                    includepattern.add(stripped);
                }
                
                excludepattern = null;
            }
            else if (p == 0) {
                includepattern = null;

                excludepattern = new ArrayList<>();
                cleanedExpr = cleanedExpr.replaceAll("^\\s+!", "");
                for (String splitExpr : cleanedExpr.split(",")) {
                    String stripped = splitExpr.trim();
                    excludepattern.add(stripped);
                }
            }
            else {
                String[] exprSplit = cleanedExpr.split("!");

                String expr1 = exprSplit[0];
                includepattern = new ArrayList<>();
                for (String splitExpr : expr1.split(",")) {
                    String stripped = splitExpr.trim();
                    includepattern.add(stripped);
                }

                excludepattern = new ArrayList<>();
                String expr2 = exprSplit[1];
                for (String splitExpr : expr2.split(",")) {
                    String stripped = splitExpr.trim();
                    excludepattern.add(stripped);
                }
            }
        }
    }

    public boolean match(String value) {
        value = value.trim();

        boolean foundinclude;
        if (includepattern == null) {
            foundinclude = true;
        }
        else {
            foundinclude = false;
            for (String p : includepattern) {
                String cleaned = p.replaceAll("([^0]+)0+$", "$1");
                if (value.startsWith(cleaned)) {
                    foundinclude = true;
                    break;
                }
            }
        }

        boolean foundexclude;
        if (excludepattern == null) {
            foundexclude = false;
        }
        else {
            foundexclude = false;
            for (String p : excludepattern) {
                String cleaned = p.replaceAll("([^0]+)0+$", "$1");
                if (value.startsWith(cleaned)) {
                    foundexclude = true;
                    break;
                }
            }
        }

        return foundinclude && !foundexclude;
    }

    @Override
    public String toString() {
        return String.format("EcoregionPattern(%s, %s)", includepattern, excludepattern);
    }

}
