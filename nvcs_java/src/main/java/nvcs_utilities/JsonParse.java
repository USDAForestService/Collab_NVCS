package nvcs_utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class JsonParse {

    public ArrayList<JsonRow> rows;

    public JsonParse(String json) {
        rows = new ArrayList<>();

        String rowsContent = json
        .replaceAll("^\\s*\\{\\s*\"*rows\"*\\s*:\\s*\\[\\s*\\{\\s*", "")
        .replaceAll("\\s*\\}\\s*\\]\\s*\\}\\s*$", "");

        String[] splitRows = rowsContent.split("\\},\\{");
        for (String row : splitRows) {
            JsonRow jsonRow = parse(row);
            this.rows.add(jsonRow);
        }
    }

    public static JsonRow parse(String json) {
        json = json
        .replaceAll("^\\{", "")
        .replaceAll("\\}$", "");

        String[] jsonPairs = json.split(",");
        HashMap<String,String> attributes = new HashMap<>();
        for (String jsonPair : jsonPairs) {
            String[] splitJsonPair = jsonPair.split(":");
            String key = splitJsonPair[0].replaceAll("\"", "");
            String value = splitJsonPair[1].replaceAll("\"", "");
            value = value.equals("null") ? null : value;
            attributes.put(key, value);
        }

        JsonRow row = new JsonRow();
        row.IDENT = attributes.get("IDENT") == null ? "" : attributes.get("IDENT");
        row.RSCD = attributes.get("RSCD") == null ? "" : attributes.get("RSCD");
        row.STATEAB = attributes.get("STATEAB") == null ? "" : attributes.get("STATEAB");
        row.ECOREGION = attributes.get("ECOREGION") == null ? "" : attributes.get("ECOREGION");
        row.PLANTATION = attributes.get("PLANTATION") == null ? "" : attributes.get("PLANTATION");
        row.HYDRIC = attributes.get("HYDRIC") == null ? "" : attributes.get("HYDRIC");
        row.RIVERINE = attributes.get("RIVERINE") == null ? "" : attributes.get("RIVERINE");
        row.ELEVATION = attributes.get("ELEVATION") == null ? "" : attributes.get("ELEVATION");
        row.BALIVE = attributes.get("BALIVE") == null ? "0" : attributes.get("BALIVE");
        row.FBCOV = attributes.get("FBCOV") == null ? "0" : attributes.get("FBCOV");
        row.GRCOV = attributes.get("GRCOV") == null ? "0" : attributes.get("GRCOV");
        row.SHCOV = attributes.get("SHCOV") == null ? "0" : attributes.get("SHCOV");
        row.TTCOV = attributes.get("TTCOV") == null ? "0" : attributes.get("TTCOV");
        row.NTCOV = attributes.get("NTCOV") == null ? "0" : attributes.get("NTCOV");
        row.SPECIES = attributes.get("SPECIES") == null ? "" : attributes.get("SPECIES");
        row.RIV = attributes.get("RIV") == null ? "0" : attributes.get("RIV");
        row.WETLAND = attributes.get("WETLAND") == null ? "" : attributes.get("WETLAND");
        row.RUDERAL = attributes.get("RUDERAL") == null ? "" : attributes.get("RUDERAL");
        row.EXOTIC = attributes.get("EXOTIC") == null ? "" : attributes.get("EXOTIC");
        row.SOFTWOODHARDWOOD = attributes.get("SOFTWOODHARDWOOD") == null ? "" : attributes.get("SOFTWOODHARDWOOD");
        row.PLANTED = attributes.get("PLANTED") == null ? "" : attributes.get("PLANTED");
        row.TALLYTREE = attributes.get("TALLYTREE") == null ? "" : attributes.get("TALLYTREE");
        row.SPCOV = attributes.get("SPCOV") == null ? "0" : attributes.get("SPCOV");

        return row;
    }

    public static String OutputToJson(Integer classification, Integer[] path) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        stringBuilder.append(String.format("\"classification\": \"%s\", ", classification));
        stringBuilder.append(String.format("\"path\": %s", Arrays.toString(path)));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public static Object[] JsonToOutput(String json) {
        String classification = json
            .split("^.*\\\"classification\\\": \\\"")[1]
            .split("\"")[0];

        String[] path = json
            .split("^.*\\\"path\\\": \\[")[1]
            .split("\\]")[0]
            .split(", ");
        
        Object[] response = new Object[2];
        response[0] = classification;
        response[1] = path;
        return response;
    }
}
