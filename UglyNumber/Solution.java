package UglyNumber;

/**
 * Created by Alan on 8/29/15.
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 2 != 0 && (num % 3 != 0) && (num % 5 != 0)) {
            return false;
        }
        if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        }
        return false;
    }
}
