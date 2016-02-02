package WordbreakTwo;

import java.util.*;

/**
 * Created by Alan on 2/1/2016.
 */
public class Solution {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();

        return getBreak(s, wordDict, map);
    }

    public List<String> getBreak(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        for (int i = 1; i <= s.length(); i++) {
            String curString = s.substring(0, i);
            if (wordDict.contains(curString)) {
                if (i == s.length()) {
                    result.add(curString);
                } else {
                    List<String> tmpResult = getBreak(s.substring(i), wordDict, map);
                    for (String str : tmpResult) {
                        result.add(curString + " " + str);
                    }
                }
            }
        }

        map.put(s, result);
        return result;
    }
}
