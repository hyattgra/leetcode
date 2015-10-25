package SubsetsII;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 8/4/15.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int preSize = ret.size();
            for (int j = start; j < preSize; j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(ret.get(j));
                tmp.add(nums[i]);
                ret.add(tmp);
            }
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                start = preSize;
            }else{
                start = 0;
            }
        }
        return ret;

    }
}
