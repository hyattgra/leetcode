package MinimumSizeSubarraySum;

/**
 * Created by Alan on 9/9/15.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int total = 0;
        int start = 0;
        int count = nums.length;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            while (total >= s) {
                flag = true;
                count = count > i - start + 1 ? i - start + 1 : count;
                total -= nums[start++];
            }
        }
        return flag ? count : 0;
    }
}
