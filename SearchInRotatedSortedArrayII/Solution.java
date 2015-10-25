package SearchInRotatedSortedArrayII;

/**
 * Created by Alan on 8/2/15.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m])
                return true;
            if (nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else if (nums[m] > nums[r]) {
                if (target >= nums[l] && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                r--;
            }
        }
        return false;
    }
}
