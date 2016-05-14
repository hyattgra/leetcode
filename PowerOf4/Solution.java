package PowerOf4;

/**
 * Created by Alan on 5/14/2016.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        double result = Math.log((double) num) / Math.log(4);
        return result == Math.floor(result);
    }
}
