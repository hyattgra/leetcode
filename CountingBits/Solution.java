package CountingBits;

/**
 * Created by Alan on 5/8/2016.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        int offset = 0;
        int nextPowOfTwo = 1;

        for (int i = 1; i <= num; i++) {
            if (i == nextPowOfTwo) {
                ret[i] = 1;
                offset = nextPowOfTwo;
                nextPowOfTwo = 2 * nextPowOfTwo;
            } else {
                ret[i] = 1 + ret[i - offset];
            }
        }
        return ret;
    }
}
