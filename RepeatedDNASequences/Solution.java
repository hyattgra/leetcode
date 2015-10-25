package RepeatedDNASequences;

import java.util.*;

/**
 * Created by gzhou on 8/18/15.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        for (int i = 9; i < s.length(); i++) {
            String ss = s.substring(i - 9, i + 1);
            int encoded = encode(ss);
            if (!map.containsKey(encoded)) {
                map.put(encoded, 1);
            } else {
                if (map.get(encoded) == 1) {
                    ret.add(ss);
                }
                map.put(encoded, map.get(encoded) + 1);
            }
        }
        return ret;
    }

    private int encode(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res *= 10;
            if (s.charAt(i) == 'A') {
                res += 1;
            } else if (s.charAt(i) == 'C') {
                res += 2;
            } else if (s.charAt(i) == 'G') {
                res += 3;
            } else {
                res += 4;
            }
        }
        return res;
    }
}
