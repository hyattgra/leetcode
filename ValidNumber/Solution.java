package ValidNumber;

/**
 * Created by Alan on 11/8/14.
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println();
    }

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return false;
        }

        int sighCount = 0;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasDot = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!isValid(c)) {
                return false;
            }

            if (c >= '0' && c <= '9') {
                hasNum = true;
            }

            if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                if (i == n - 1) {
                    return false;
                }
                hasE = true;
            }

            if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                if (i == n - 1 && !hasNum) {
                    return false;
                }
                hasDot = true;
            }

            if (c == '-' || c == '+') {
                if (sighCount == 2) {
                    return false;
                }

                if (i == n - 1) {
                    return false;
                }
                if (i > 0 && !hasE) {
                    return false;
                }
                sighCount++;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return c == '.' || c == '+' || c == '-' || c == 'e' || c == 'E' || c >= '0' && c <= '9';
    }
}
