package BurstBalloons;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];

        for (int j = 1; j <= len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int localMax = 0;
                for (int k = i; k < j; k++) {
                    localMax = Math.max(localMax, dp[i][k] + dp[k + 1][j] +
                            nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == len ? 1 : nums[j]));
                }
                dp[i][j] = localMax;
            }
        }

        return dp[0][len];

    }
}
