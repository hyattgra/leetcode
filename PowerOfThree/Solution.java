package PowerOfThree;

/**
 * Created by Alan on 1/30/2016.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        double ret = Math.log(n) / Math.log(3);
        return Math.abs(ret - Math.rint(ret)) < 0.000000000001;
    }
}
