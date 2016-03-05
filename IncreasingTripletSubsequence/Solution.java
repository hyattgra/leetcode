package IncreasingTripletSubsequence;

/**
 * Created by Alan on 3/5/2016.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (Integer n : nums) {
            if (n <= min) {
                min = n;
            } else if (secondMin > n) {
                secondMin = n;
            } else if (n > secondMin) {
                return true;
            }
        }
        return false;
    }
}
