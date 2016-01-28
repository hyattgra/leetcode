package SuperUglyNumber;

/**
 * Created by gzhou on 1/28/16.
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] factor = new int[primes.length];
        System.arraycopy(primes, 0, factor, 0, primes.length);

        int[] index = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < factor.length; j++) {
                min = Math.min(min, factor[j]);
            }

            ugly[i] = min;

            for (int j = 0; j < factor.length; j++) {
                if (min == factor[j]) {
                    factor[j] = primes[j] * ugly[++index[j]];
                }
            }
        }

        return ugly[n - 1];
    }
}
