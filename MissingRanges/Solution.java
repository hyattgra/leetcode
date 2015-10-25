package MissingRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 9/29/2015.
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) {  //Empty array misses the range lower->upper.
            ret.add(output(lower, upper));
            return ret;
        }
        int prev;
        if (lower < nums[0]) {
            ret.add(output(lower, nums[0] - 1));
            prev = nums[0];
        } else {
            prev = lower;
        }
        for (int i : nums) {
            if (i > prev + 1) {
                ret.add(output(prev + 1, i - 1));
            }
            prev = i;
        }

        if (upper > prev) {
            ret.add(output(prev + 1, upper));
        }
        return ret;
    }

    private String output(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
