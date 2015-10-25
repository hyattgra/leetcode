package UniquePathsTwo;

/**
 * Created by Alan on 7/8/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] test = new int[2][2];
        test[0][0] = 0;
        test[0][1] = 0;
        test[1][0] = 1;
        test[1][1] = 0;
        System.out.print(uniquePathsWithObstacles(test));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        if (obstacleGrid[0][0] == 0) {
            dp[0] = 1;
        }
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }

        return dp[width - 1];
    }
}
