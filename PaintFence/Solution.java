package PaintFence;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int[] ret = new int[n + 1];

        ret[0] = 0;
        ret[1] = k;
        ret[2] = k * k;
        for (int i = 3; i <= n; i++) {
            ret[i] = (k - 1) * (ret[i - 1] + ret[i - 2]);
        }

        return ret[n] > 0 ? ret[n] : 0;

    }
}
