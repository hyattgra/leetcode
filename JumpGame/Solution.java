package JumpGame;

/**
* Created by Alan on 6/19/15.
*/
public class Solution {

    public static void main(String[] args) {
        int[] test = {3, 2, 1, 0, 4};
        System.out.print(canJump(test));
    }

    public static boolean canJump(int[] nums) {
        int last = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = cur;
            }
            cur = Math.max(cur, i + nums[i]);
            // last cant not reach i, then false
            if(last < i){
                return false;
            }
        }
        return true;
    }
}
