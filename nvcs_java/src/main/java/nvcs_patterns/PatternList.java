package nvcs_patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nvcs_components.KeyValue;

public class PatternList {

    public String label;
    public List<PatternGroup> alternatives;

    public PatternList(String label, List<List<KeyValue>> pattgrps) {
        if (pattgrps == null) {
            throw new RuntimeException("PatternList is empty");
        }
        this.label = label;
        this.alternatives = new ArrayList<>();
        for (List<KeyValue> pattgrp : pattgrps) {
            HashMap<String,String> hashMap = new HashMap<>();
            for (KeyValue pattern : pattgrp) {
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
