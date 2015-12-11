package ThreeSumSmaller;

import java.util.Arrays;

/**
 * Created by Alan on 12/11/2015.
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ret = 0;
        Arrays.sort(nums);
        int lo, hi;

        for (int i = 0; i <= nums.length - 3; i++) {
            lo = i + 1;
            hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] < target) {
                    ret += hi - lo;
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        return ret;

    }
}
