package PalindromePermutationTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alan on 5/5/2016.
 */
public class Solution {
    List<String> ret = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();

    public List<String> generatePalindromes(String s) {
        if (s == null || s.length() == 0) {
            return ret;
        }

        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        String beginning = "";
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (!hasOdd) {
                    hasOdd = true;
                    beginning = entry.getKey().toString();
                    map.put(entry.getKey(), map.get(entry.getKey()) - 1);
                } else {
                    return ret;
                }
            }
        }
        genPalin(beginning, s.length());
        return ret;
    }

    private void genPalin(String beginning, int len) {
        if (beginning.length() == len) {
            ret.add(new String(beginning));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            map.put(entry.getKey(), map.get(entry.getKey()) - 2);
            String tmp = entry.getKey() + beginning + entry.getKey();
            genPalin(tmp, len);
            map.put(entry.getKey(), map.get(entry.getKey()) + 2);

        }
    }
}
