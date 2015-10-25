package JumpGameII;

/**
 * Created by gzhou on 6/8/15.
 */
public class Solution {
    public static void main(String[] args) {
        int[] test = {2,1,1,1,4};
        System.out.print(jump(test));
    }

    public static int jump(int[] nums) {
        int cur = 0;
        int last = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = cur;
                ret++;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return ret;
    }
}
