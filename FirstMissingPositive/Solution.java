package FirstMissingPositive;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzhou on 5/29/15.
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (0 < nums[i] && nums[i] <= nums.length && nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1] )  {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}

