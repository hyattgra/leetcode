package DivideTwoIntegers;

/**
 * Created by Alan on 10/13/14.
 */
public class Solution {
    public static void main(String[] args) {

        int re = divide(5, 2);

        System.out.println(re);

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) {
            return dividend;
        }

        long dd = dividend;
        long ds = divisor;

        boolean neg = false;
        int result = 0;

        if (dividend < 0) {
            neg = !neg;
            dd = -dd;
        }
        if (divisor < 0) {
            neg = !neg;
            ds = -ds;
        }

        long[] multi = new long[32];

        for (int i = 0; i < 32; i++) {
            multi[i] = ds << i;
        }
        for (int i = 31; i >=0; i--) {
            if (dd - multi[i] >= 0) {
                result += 1 << i;
                dd -= multi[i];
            }
        }

        result = neg ? -result : result;

        return result;

    }
}
