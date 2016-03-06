package WiggleSortII;

import java.util.Arrays;

/**
 * Created by Alan on 3/6/2016.
 */
public class Solution {
    public void wiggleSort(int[] nums) {

        //not meet the followup
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) / 2;
        int t = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            temp[i] = i % 2 == 0 ? nums[--s] : nums[--t];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }
}
