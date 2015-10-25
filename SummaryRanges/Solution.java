package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 8/23/15.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length > 0) {
            int start = 0;
            int prev = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[prev] + 1) {
                    construct(start, prev, ret, nums);
                    start = i;
                    prev = i;
                } else {
                    prev = i;
                }
            }
            construct(start, nums.length - 1, ret, nums);
        }

        return ret;
    }

    private void construct(int start, int end, List<String> ret, int[] nums) {
        if (end - start > 0) {
            ret.add(nums[start] + "->" + nums[end]);

        } else {
            ret.add(nums[start] + "");
        }
    }
}
