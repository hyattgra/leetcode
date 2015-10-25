package SingleNumberTwo;

/**
 * Created by Alan on 8/4/15.
 */
public class Solution {
    public int singleNumber(int[] nums) {

        // hacky, remember
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += ((nums[j] >> i) & 1);
            }
            result |= ((count % 3) << i);
        }

        return result;

    }
}
