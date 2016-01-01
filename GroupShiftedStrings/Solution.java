package GroupShiftedStrings;

import java.util.*;

/**
 * Created by Alan on 1/1/2016.
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String k = getKey(s);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<String>());
            }
            map.get(k).add(s);
        }

        for (List<String> list : map.values()) {
            Collections.sort(list);
            ret.add(list);
        }
        return ret;
    }

    private String getKey(String s) {
        int[] key = new int[s.length()];
        key[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(0) > 0 ? s.charAt(i) - s.charAt(0) : 26 - (s.charAt(0) - s.charAt(i));
            key[i] = diff;
        }
        return Arrays.toString(key);
    }
}
