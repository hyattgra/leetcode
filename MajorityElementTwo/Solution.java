package MajorityElementTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 5/15/2016.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int[] candidates = new int[2];
        int[] count = new int[2];
        List<Integer> ret = new ArrayList<>();

        for (Integer num : nums) {
            if (candidates[0] == num) {
                count[0]++;
            } else if (candidates[1] == num) {
                count[1]++;
            } else if (count[0] == 0) {
                candidates[0] = num;
                count[0] = 1;
            } else if (count[1] == 0) {
                candidates[1] = num;
                count[1] = 1;
            } else {
                count[0]--;
                count[1]--;
            }
        }
        count[0] = 0;
        count[1] = 0;

        for (Integer num : nums) {
            if (num == candidates[0]) {
                count[0]++;
            } else if (num == candidates[1]) {
                count[1]++;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (count[i] > nums.length / 3 && !ret.contains(candidates[i])) {
                ret.add(candidates[i]);
            }
        }
        return ret;
    }
}
