package nvcs_java.nvcs_patterns;

import java.util.HashMap;
import java.util.Map;

public class PatternGroup {
    
    public Map<String,Pattern> pattgrp;

    public PatternGroup(Map<String,String> pattgrp) {
        this.pattgrp = new HashMap<>();
        for (Map.Entry<String,String> entry : pattgrp.entrySet()) {
            String attr = entry.getKey();
            String value = entry.getValue();

            String attrClass = Pattern.attrpatts.get(attr);
            switch (attrClass) {
                case "Pattern":
                    this.pattgrp.put(attr, new Pattern(value));
                    break;
                case "_EcoregionPattern":
                    //this.pattgrp.put(attr, new _EcoregionPattern(value));
                    break;
                default:
                    throw new RuntimeException("Invalid class name registered: " + attrClass);
            }
        }
    }

    public boolean match_all(Map<String,String> valugrp) {
        boolean result = true;
        for (String attr : this.pattgrp.keySet()) {
            if (!this.pattgrp.get(attr).match(valugrp.get(attr))) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("PatternGroup(%s)", pattgrp);
    }

}
