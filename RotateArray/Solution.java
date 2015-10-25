package RotateArray;

/**
 * Created by Alan on 7/30/15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            copy[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = copy[i];
        }

    }
}
