package ProductOfArrayExceptSelf;

/**
 * Created by Alan on 8/23/15.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                output[i] = 1;
            } else {
                output[i] = output[i - 1] * nums[i - 1];
            }
        }
        int tmp = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] = output[i] * tmp;
            tmp = tmp*nums[i];
        }
        return output;
    }
}
