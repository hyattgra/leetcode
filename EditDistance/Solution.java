package EditDistance;

/**
 * Created by Alan on 12/12/14.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(minDistance("SADASd", "www111Sd"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    int del = dp[i + 1][j] + 1;
                    int ins = dp[i][j + 1] + 1;
                    int rep = dp[i][j] + 1;
                    int minD = Math.min(del, Math.min(ins, rep));
                    dp[i+1][j+1] = minD;
                } else if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[len1][len2];

    }


}