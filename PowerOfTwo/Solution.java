package PowerOfTwo;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        double i = 2;
        if (n <= 0) {
            return false;
        }
        if (n <= i) {
            return true;
        }

        while (i * 2 < n) {
            i = i * 2;
        }

        if (i * 2 == n) {
            return true;
        }
        return false;
    }
}
