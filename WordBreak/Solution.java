package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alan on 1/18/15.
 */
public class Solution {

    public static void main(String[] args) {
//        Set<String> dict = new HashSet<>();
//        dict.add("leet");
//        dict.add("code");
//
//        System.out.print(wordBreak("leetcode", dict));

    }

    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (String ss : dict) {
                int len = ss.length();
                int end = i + len;

                if (end > s.length()) {
                    continue;
                }

                if (dp[end]) {
                    continue;
                }

                if (s.substring(i, end).equals(ss)) {
                    dp[end] = true;
                }

            }
        }
        return dp[s.length()];
    }
}
