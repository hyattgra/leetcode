package PaintHouseTwo;

/**
 * Created by Alan on 1/1/2016.
 */
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                dp[i][j] = findMin(dp[i - 1], j) + costs[i][j];
            }
        }

        return findMin(dp[costs.length - 1], -1);
    }

    private int findMin(int[] cost, int j) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cost.length; i++) {
            if (i == j) {
                continue;
            } else {
                min = Math.min(cost[i], min);
            }
        }
        return min;
    }
}
