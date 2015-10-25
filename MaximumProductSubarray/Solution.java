package MaximumProductSubarray;

/**
 * Created by Alan on 8/15/15.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            max[i] = getMax(nums[i], max[i-1]*nums[i], min[i-1]*nums[i]);
            min[i] = getMin(nums[i], max[i-1]*nums[i], min[i-1]*nums[i]);
            if(max[i] > max[index]){
                index = i;
            }
        }
        return max[index];
    }

    private int getMax(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    private int getMin(int a, int b, int c) {
        return a < b ? (a > c ? c : a) : (b > c ? c : b);
    }

}
