package TrappingRainWater;

/**
 * Created by gzhou on 6/1/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(test));
    }

    public static int trap(int[] height) {
        int[] fwd = new int[height.length];
        int leftMostHigh = 0;
        for (int i = 0; i < height.length; i++) {
            if (leftMostHigh != 0 && height[i] < leftMostHigh) {
                fwd[i] = leftMostHigh;
            }
            leftMostHigh = Math.max(leftMostHigh, height[i]);
        }

        int rightMostHigh = 0;
        int[] rwd = new int[height.length];
        for (int j = height.length - 1; j >= 0; j--) {
            if (rightMostHigh != 0 && height[j] < rightMostHigh) {
                rwd[j] = rightMostHigh;
            }
            rightMostHigh = Math.max(rightMostHigh, height[j]);
        }
        int res = 0;
        for (int k = 0; k < height.length; k++) {
            if(fwd[k]> height[k] && rwd[k] > height[k]){
                res += Math.min(fwd[k], rwd[k]) - height[k];
            }
        }
        return res;
    }
}