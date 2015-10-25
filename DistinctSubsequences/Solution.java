package DistinctSubsequences;

/**
 * Created by gzhou on 8/25/15.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            char tt = t.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                char ss = s.charAt(j);
                if (tt != ss) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                }
            }
        }
        return dp[t.length()][s.length()];

    }
}
