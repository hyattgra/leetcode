package SingleNumberIII;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alan on 9/1/15.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        int[] ret = new int[set.size()];
        int c = 0;
        for (int i : set) {
            ret[c] = i;
            c++;
        }
        return ret;
    }
}
