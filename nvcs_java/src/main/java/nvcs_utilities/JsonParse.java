package nvcs_utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class JsonParse {

    public ArrayList<TreeMap<String,String>> rows;

    public JsonParse(String json) {
        rows = new ArrayList<>();

        String rowsContent = json
        .replaceAll("^\\s*\\{\\s*\"*rows\"*\\s*:\\s*\\[\\s*\\{\\s*", "")
        .replaceAll("\\s*\\}\\s*\\]\\s*\\}\\s*$", "");

        String[] splitRows = rowsContent.split("\\},\\{");
        for (String row : splitRows) {
            TreeMap<String,String> jsonRow = parse(row);
            this.rows.add(jsonRow);
        }
    }

    public static TreeMap<String,String> parse(String json) {
        json = json
        .replaceAll("^\\{", "")
        .replaceAll("\\}$", "");

        String[] jsonPairs = json.split(",");
        TreeMap<String,String> row = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (String jsonPair : jsonPairs) {
            String[] splitJsonPair = jsonPair.split(":");
            String key = splitJsonPair[0].replaceAll("\"", "");
            String value = splitJsonPair[1].replaceAll("\"", "");
            value = value.equals("null") ? null : value;
            row.put(key, value);
        }

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
