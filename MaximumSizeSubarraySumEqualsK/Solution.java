package MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 1/30/2016.
 */
public class Solution {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int ret = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                ret = Math.max(ret, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return ret;
    }
}
