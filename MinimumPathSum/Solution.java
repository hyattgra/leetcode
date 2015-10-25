package MinimumPathSum;

/**
 * Created by Alan on 7/12/15.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int j = 0; j < grid[0].length; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];
    }
}
