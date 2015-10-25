package SearchinRotatedSortedArray;

/**
 * Created by Alan on 10/18/14.
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(search(nums, 2));


    }


    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m])
                return m;
            if (nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                if (target >= nums[l] && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return -1;

    }
}
