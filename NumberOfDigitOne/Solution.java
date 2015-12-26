package NumberOfDigitOne;

/**
 * Created by Alan on 12/26/2015.
 */
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        } else if (n < 10) {
            return 1;
        }

        int base = (int) Math.pow(10, String.valueOf(n).length() - 1);
        int ans = n / base;
        int reminder = n % base;
        int oneInBase = 0;

        if (ans == 1) {
            oneInBase = n - base + 1;
        } else {
            oneInBase = base;
        }

        return countDigitOne(base - 1) * ans + oneInBase + countDigitOne(reminder);
    }
}
