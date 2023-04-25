package hexlet.code;


import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {
    public static String generate(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        Set<String> set = new TreeSet<>();
        set.addAll(mapOne.keySet());
        set.addAll(mapTwo.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n ");
        for (String key : set) {
            if (mapOne.containsKey(key) && !mapTwo.containsKey(key)) {
                stringBuilder.append("- ").append(key).append(": ").append(mapOne.get(key)).append("\n ");
            } else if (!mapOne.containsKey(key) && mapTwo.containsKey(key)) {
                stringBuilder.append("+ ").append(key).append(": ").append(mapTwo.get(key)).append("\n ");
            } else {
                if (mapOne.get(key).equals(mapTwo.get(key))) {
                    stringBuilder.append("  ").append(key).append(": ").append(mapOne.get(key)).append("\n ");
                } else {
                    stringBuilder.append("- ").append(key).append(": ").append(mapOne.get(key)).append("\n ");
                    stringBuilder.append("+ ").append(key).append(": ").append(mapTwo.get(key)).append("\n ");
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

}
