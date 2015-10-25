package LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Alan on 12/3/14.
 */
public class Solution {
    public static void main(String[] args) {

        String s = "adad";

        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        int max = 0;
//        int start = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int tmp;
//            if (map.containsKey(c)) {
//                tmp = map.get(c) + 1;
//            } else {
//                tmp = 0;
//            }
//            start = Math.max(start, tmp);
//            max = Math.max(max, i - start + 1);
//            map.put(c, i);
//        }
//
//        return max;

        //version 2.0
        if (s.isEmpty()) {
            return 0;
        }

        int[] dict = new int[256];
        Arrays.fill(dict, -1);
        int max = 0;
        int start = 0, end = 0;
        dict[s.charAt(0)] = 0;
        while (end < s.length()) {
            if (dict[s.charAt(end)] >= start) {
                start = dict[s.charAt(end)] + 1;
            }
            max = Math.max(max, end - start + 1);
            dict[s.charAt(end)] = end;
            end++;
        }
        return max;
    }
}

