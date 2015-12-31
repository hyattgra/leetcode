package FindTheDuplicateNumber;

/**
 * Created by Alan on 12/31/2015.
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int count = 0;
            int mid = low + (high - low) / 2;
            for (Integer i : nums) {
                if (i <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
