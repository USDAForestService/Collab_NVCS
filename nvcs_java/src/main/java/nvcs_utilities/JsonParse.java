package nvcs_utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        row.IDENT = attributes.get("IDENT");
        row.RSCD = attributes.get("RSCD");
        row.STATEAB = attributes.get("STATEAB");
        row.ECOREGION = attributes.get("ECOREGION");
        row.PLANTATION = attributes.get("PLANTATION");
        row.HYDRIC = attributes.get("HYDRIC");
        row.RIVERINE = attributes.get("RIVERINE");
        row.ELEVATION = attributes.get("ELEVATION");
        row.BALIVE = attributes.get("BALIVE");
        row.FBCOV = attributes.get("FBCOV");
        row.GRCOV = attributes.get("GRCOV");
        row.SHCOV = attributes.get("SHCOV");
        row.TTCOV = attributes.get("TTCOV");
        row.NTCOV = attributes.get("NTCOV");
        row.SPECIES = attributes.get("SPECIES");
        row.RIV = attributes.get("RIV");
        row.WETLAND = attributes.get("WETLAND");
        row.RUDERAL = attributes.get("RUDERAL");
        row.EXOTIC = attributes.get("EXOTIC");
        row.SOFTWOODHARDWOOD = attributes.get("SOFTWOODHARDWOOD");
        row.PLANTED = attributes.get("PLANTED");
        row.TALLYTREE = attributes.get("TALLYTREE");
        row.SPCOV = attributes.get("SPCOV");

        return row;
    }
}
