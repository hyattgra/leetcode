package AdditiveNumber;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;

        for (int i = 0; i < num.length() - 2; i++) {

            //check for leading 0
            if (num.charAt(0) == '0' && i > 0) break;

            Long num1 = Long.parseLong(num.substring(0, i + 1));

            for (int j = i + 1; j < num.length() - 1; j++) {

                if (num.charAt(i + 1) == '0' && j > i + 1) break;

                Long num2 = Long.parseLong(num.substring(i + 1, j + 1));

                if (helper(num, j + 1, num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(String num, int index, Long num1, Long num2) {
        if (index == num.length()) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) break;

            Long sum = Long.parseLong(num.substring(index, i + 1));

            if (sum == num1 + num2) {
                return helper(num, i + 1, num2, sum);
            }
        }
        return false;
    }
}
