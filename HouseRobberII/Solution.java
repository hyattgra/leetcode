package HouseRobberII;

/**
 * Created by gzhou on 8/21/15.
 */
public class Solution {
    public int rob(int[] nums) {

        return Math.max(robHouse(nums, true), robHouse(nums, false));
    }

    private int robHouse(int[] nums, boolean robFirst) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = robFirst ? nums[0] : 0;
        for (int i = 2; i <= nums.length; i++) {
            if (i != nums.length) {
                dp[i] = Math.max(nums[i-1] + dp[i - 2], dp[i - 1]);
            } else {
                dp[i] = robFirst ? dp[i - 1] : Math.max(nums[i-1] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[nums.length];
    }
}
