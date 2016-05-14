package WordPatternTwo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 5/14/2016.
 */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();

        return helper(pattern, 0, str, 0, map);

    }

    private boolean helper(String pattern, int idxP, String str, int idxS, Map<Character, String> map) {

        if (idxP == pattern.length() && idxS == str.length()) {
            return true;
        }
        if (idxP == pattern.length() || idxS == str.length()) {
            return false;
        }
        char c = pattern.charAt(idxP);
        for (int i = idxS; i < str.length(); i++) {
            String subString = str.substring(idxS, i + 1);

            if (map.containsKey(c) && map.get(c).equals(subString)) {
                if (helper(pattern, idxP + 1, str, i + 1, map)) {
                    return true;
                }
            }
            if (!map.containsKey(c) && !map.values().contains(subString)) {
                map.put(c, subString);
                if (helper(pattern, idxP + 1, str, i + 1, map)) {
                    return true;
                }
                map.remove(c);
            }
        }
        return false;
    }
}
