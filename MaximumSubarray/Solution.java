package MaximumSubarray;

/**
 * Created by Alan on 6/13/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[] res = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(res));
    }
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //check sum trend if is going up
            curMax = Math.max(curMax+nums[i], nums[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
