package ImplementstrStr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alan on 10/13/14.
 */
public class Solution {
    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.test();

    }

    public void test() {
//        String haystack = "my name is alan, and the name is not my real name, but a nick-name";
//        String needle = "name";
        String haystack = "babba";
        String needle = "bbb";
        System.out.println(strStr(haystack, needle));
    }

    public String strStr(String haystack, String needle) {

//        List<Integer> matches = new ArrayList<Integer>();
//        int m = text.length();
//        int n = pattern.length();
//        Map<Character, Integer> rightMostIndexes = preprocess(pattern);
//        int alignedAt = 0;
//        while (alignedAt + (n - 1) < m) {
//            for (int indexInPattern = n - 1; indexInPattern >= 0; indexInPattern--) {
//                int indexInText = alignedAt + indexInPattern;
//                char x = text.charAt(indexInText);
//                char y = pattern.charAt(indexInPattern);
//                if (indexInText >= m) break;
//                if (x != y) {
//                    Integer r = rightMostIndexes.get(x);
//                    if (r == null) {
//                        alignedAt = indexInText + 1;
//                    }
//                    else {
//                        int shift = indexInText - (alignedAt + r);
//                        alignedAt += shift > 0 ? shift : 1;
//                    }
//                    break;
//                }
//                else if (indexInPattern == 0) {
//                    matches.add(alignedAt);
//                    alignedAt++;
//                }
//            }
//        }
//
//        if (matches.size() == 0) {
//            return null;
//        }
//
//        return text.substring(matches.get(0));

        if (needle.length() == haystack.length() && needle.length() == 0)
            return "";

        if (needle.length() == 0){
            return haystack;
        }

        List<Integer> matches = new ArrayList<Integer>();
        int indexInText;
        int alignedAt = 0;
        int indexInPattern;

        int m = haystack.length();
        int n = needle.length();

        HashMap<Character, Integer> map = preprocess(needle);

        while (alignedAt + n - 1 < m) {
            for (indexInPattern = needle.length() - 1; indexInPattern >= 0; indexInPattern--) {
                indexInText = alignedAt + indexInPattern;
                if (indexInText >= m) {
                    break;
                }
                char x = haystack.charAt(indexInText);
                char y = needle.charAt(indexInPattern);
                if (x != y) {
                    Integer r = map.get(x);
                    if (r == null) {
                        alignedAt = indexInText + 1;
                    } else {
                        int shift = indexInText - (alignedAt + r);
                        alignedAt += shift > 0 ? shift : 1;
                    }
                    break;
                } else if (indexInPattern == 0) {
                    matches.add(alignedAt);
                    alignedAt++;
                }
            }
        }
/*
        int pos = haystack.lastIndexOf(needle);
        System.out.println("ER " + pos );
*/
        if (matches.size() == 0) {
            return null;
        }

        int pos = matches.get(0);

        return haystack.substring(pos);

    }

    public HashMap<Character, Integer> preprocess(String pattern) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), i);
            }
        }
        return map;
    }

}
