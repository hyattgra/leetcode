package FindMinimumInRotatedSortedArrayII;

/**
 * Created by Alan on 8/29/15.
 */
public class Solution {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return nums[0];
        }

        int mid = lo + (hi - lo) / 2;
        if (mid > 0 && nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }
        if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }

        if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) {
            return Math.min(search(nums, lo, mid - 1), search(nums, mid + 1, hi));
        }

        if (nums[mid] >= nums[lo]) {
            return search(nums, mid + 1, hi);
        } else if (nums[mid] <= nums[hi]) {
            return search(nums, lo, mid - 1);
        }
        return -1;
    }
}
