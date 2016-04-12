package PatchingArray;

/**
 * Created by Alan on 4/10/2016.
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int miss = 1, added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }

}
