package PalindromePartitioningII;

/**
 * Created by Alan on 12/11/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static int minCut(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }

        int len = s.length();

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = len - 1 - i;
        }

        boolean[][] isPalin = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j) && (j - i < 2))
                        || (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (isPalin[i][j]) {
                    if (j == len - 1) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                    }
                }
            }
        }

        return dp[0];

    }

}
