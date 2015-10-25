package PerfectSquares;

/**
 * Created by Alan on 9/9/15.
 */
public class Solution {
    public int numSquares(int n) {
        int root = 2;
        int ret = n;
        while (root * root <= n) {
            int div = n / (root * root);
            int rem = n % (root * root);
            ret = Math.min(ret, div + numSquares(rem));
            root++;
        }
        return ret;
    }
}
