package UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.Map;


public class ValidWordAbbr {

    Map<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String str : dictionary) {
            String key = genKey(str);
            if (map.containsKey(key) && !map.get(key).equals(str)) {
                map.put(key, "");
            } else {
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(genKey(word)) || map.get(genKey(word)).equals(word);
    }

    private String genKey(String str) {
        if (str.length() <= 2) {
            return str;
        }

        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
}
