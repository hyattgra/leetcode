package FindMinimumInRotatedSortedArray;

/**
 * Created by gzhou on 7/20/15.
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i <= nums.length; i++) {
            int j = i;
            int k = (j + 1) > nums.length - 1 ? 0 : j + 1;
            if (nums[j] >= nums[k]) {
                return nums[k];
            }
        }
        return -1;
    }
}
