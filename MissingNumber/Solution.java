package MissingNumber;

/**
 * Created by Alan on 9/1/15.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        int total = (1 + nums.length) * nums.length / 2;
        return total-sum;
    }
}
