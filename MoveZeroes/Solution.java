package MoveZeroes;

import java.util.Arrays;

/**
 * Created by Alan on 1/1/2016.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        Arrays.fill(nums, index, nums.length, 0);
    }
}
