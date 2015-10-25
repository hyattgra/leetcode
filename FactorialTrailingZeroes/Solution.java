package FactorialTrailingZeroes;

/**
 * Created by Alan on 9/9/15.
 */
public class Solution {
    public int trailingZeroes(int n) {
        if (n / 5 == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}
