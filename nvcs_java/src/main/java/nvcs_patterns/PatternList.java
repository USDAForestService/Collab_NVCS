package nvcs_patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class PatternList {

    public String label;
    public List<PatternGroup> alternatives;

    public PatternList(String label, List<List<Pair<String,String>>> pattgrps) {
        if (pattgrps == null) {
            throw new RuntimeException("PatternList is empty");
        }
        this.label = label;
        this.alternatives = new ArrayList<>();
        for (List<Pair<String,String>> pattgrp : pattgrps) {
            HashMap<String,String> hashMap = new HashMap<>();
            for (Pair<String,String> pattern : pattgrp) {
                hashMap.put(pattern.getKey(), pattern.getValue());
            }
            PatternGroup entry = new PatternGroup(hashMap);
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
