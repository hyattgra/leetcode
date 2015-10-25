package LongestSubstringWithATMostTwoDistinctCharacters;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 9/8/15.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.print("ecccee".indexOf("e", 3));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int prt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && map.size() == 2) {
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                prt = s.indexOf((char) map.keySet().toArray()[0], index);
            }
            map.put(s.charAt(i), i);
            longest = Math.max(longest, i - prt + 1);
        }
        return longest;
    }
}
