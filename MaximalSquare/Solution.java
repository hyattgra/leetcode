package MaximalSquare;

/**
 * Created by gzhou on 9/24/15.
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] dp = new int[height + 1][width + 1];
        int max = 0;

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
