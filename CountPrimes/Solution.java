package CountPrimes;

/**
 * Created by Alan on 8/15/15.
 */
public class Solution {
    public int countPrimes(int n) {

        if (n == 1 || n == 0) {
            return 0;
        }
        int count = 0;
        boolean primes[] = new boolean[n + 1];
        for (int index = 2; index <= n; index++) {
            primes[index] = true;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= n; j = j + i) {
                    primes[j] = false;
                }
            }
        }

        // count
        for (int index = 2; index < n; index++) {
            if (primes[index]) {
                count++;
            }
        }
        return count;
    }

}