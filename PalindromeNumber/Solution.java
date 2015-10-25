package PalindromeNumber;

/**
 * Created by Alan on 9/20/14.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();

    }

    public void test() {
        System.out.print(isPalindrome(-2147483648));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x < 0 ? -x : x;
        int divisor = 1;
        while (y / divisor >= 10) {
            divisor *= 10;
        }
        while (divisor >= 10 && (y / divisor == y % 10)) {
            y = (y % divisor) / 10;
            divisor = divisor / 100;
        }

        if (divisor < 10) {
            return true;
        }
        return false;

    }
}
