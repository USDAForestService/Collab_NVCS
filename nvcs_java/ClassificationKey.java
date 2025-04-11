package nvcs_java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import nvcs_java.nvcs_components.Node;
import nvcs_java.nvcs_components.Plot;
import nvcs_java.nvcs_interfaces.NodeMatch;
import nvcs_java.nvcs_patterns.PatternList;

public class ClassificationKey {
    
    public Map<Integer,Node> nodes;
    public Node root_node;

    public ClassificationKey() {
        nodes = new LinkedHashMap<>();
        root_node = _setup();
    }

    public Node _setup() {
        nodes.put(0, new Node(0, null, new Object[] { "", "", (NodeMatch) plot -> true }, ""));
        nodes.put(1, new Node(1, 0, element_001(), "Forest Plantations"));

        for (Map.Entry<Integer,Node> entry : nodes.entrySet()) {
            Integer ident = entry.getKey();
            Node element = entry.getValue();
            if (element.parent != null) {
                nodes.get(element.parent).children.add(nodes.get(ident));
            }
        }

        return nodes.get(0);
    }

    public Object[] element_001() {

        // Forest Plantations

        String level = "";
        String code = "";

        // Vegetation shows evidence of intensive human management as planted vegetation,
        // such as trees being planted in rows, often dominated by single-species, and even
        // aged.  The stand is identified as planted in the FIA database (Stand Origin Code
        // = 1 "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001).
        // AND the Stand Origin Species (STDORGSP) is EITHER a Populus spp. or Exotic.

        Map<String,String> PLANTATION_values = new HashMap<>();
        PLANTATION_values.put("planted", "yes");
        PatternList PLANTATION = new PatternList("PLANTATION", PLANTATION_values);

        Map<String,String> PLANTED_EXOTIC_values = new HashMap<>();
        PLANTED_EXOTIC_values.put("planted", "yes");
        PLANTED_EXOTIC_values.put("exotic", "yes");
        PatternList PLANTED_EXOTIC = new PatternList("PLANTED_EXOTIC", PLANTED_EXOTIC_values);

        Map<String,String> PLANTED_POPULUS_values = new HashMap<>();
        PLANTED_POPULUS_values.put("planted", "yes");
        PLANTED_POPULUS_values.put("species", "Populus");
        PatternList PLANTED_POPULUS = new PatternList("PLANTED_POPULUS", PLANTED_POPULUS_values);

        NodeMatch match = plot -> (
            plot.match(PLANTATION)
            && (plot.riv(PLANTED_EXOTIC) > 0 || plot.riv(PLANTED_POPULUS) > 0)
        );

        return new Object[] { level, code, match };
    }
}
