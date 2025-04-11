package nvcs_java.nvcs_patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatternList {

    public String label;
    public List<PatternGroup> alternatives;

    @SafeVarargs
    public PatternList(String label, Map<String,String>... pattgrps) {
        if (pattgrps == null) {
            throw new RuntimeException("PatternList is empty");
        }
        this.label = label;
        this.alternatives = new ArrayList<>();
        for (Map<String,String> pattgrp : pattgrps) {
            PatternGroup entry = new PatternGroup(pattgrp);
            alternatives.add(entry);
        }
    }

    public boolean match_any(Map<String,Object> valugrp) {
        boolean result;
        if (alternatives == null) {
            result = true;
        }
        else {
            result = false;
            for (PatternGroup patterngroup : alternatives) {
                if (patterngroup.match_all(valugrp)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        return String.format("PatternList(%s, %s)", label, alternatives);
    }

}
