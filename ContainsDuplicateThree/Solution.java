package ContainsDuplicateThree;

import java.util.TreeSet;

/**
 * Created by Alan on 5/15/2016.
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (set.floor(val) != null && set.floor(val) + t > val) {
                return true;
            }

            if (set.ceiling(val) != null && set.ceiling(val) - t < val) {
                return true;
            }

            set.add(val);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
