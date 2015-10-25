package LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alan on 9/13/15.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;
        for (Integer i : nums) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int n = nums[i];

            while (set.contains(--n)) {
                count++;
                set.remove(n);
            }

            n = nums[i];

            while (set.contains(++n)) {
                count++;
                set.remove(n);
            }

            max = Math.max(max, count);
        }
        return max;

    }
}
