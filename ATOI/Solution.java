package ATOI;

/**
 * Created by Alan on 9/20/14.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();
    }

    public void test() {

        System.out.print(atoi("-2147483648"));

    }

    ////adsdasd
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();

        int neg = 1;
        int i = 0;
        if (str.charAt(0) == '-') {
            neg = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        double res = 0;
        while (i < str.length() && str.charAt(i) - '0' <= 9 && str.charAt(i) - '0' >= 0) {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (neg < 0) {
            res = res * neg;
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)res;

    }


}
