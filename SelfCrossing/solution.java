package SelfCrossing;

/**
 * Created by Alan on 4/3/2016.
 */
public class Solution {
    public boolean isSelfCrossing(int[] x) {

        if (x.length < 4) {
            return false;
        }

        for (int i = 3; i < x.length; i++) {
            if (isCrossing(x, i)) {
                return true;
            }

            if (i == 4 && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] == x[i - 3]) {
                return true;
            }

            if (i > 4 && isCrossing4(x, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCrossing(int[] x, int i) {
        return (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]);
    }

    private boolean isCrossing4(int[] x, int i) {
        return (x[i - 1] + x[i - 5] >= x[i - 3]
                && x[i] + x[i - 4] >= x[i - 2]
                && x[i - 1] <= x[i - 3]
                && x[i - 2] >= x[i - 4]);
    }
}