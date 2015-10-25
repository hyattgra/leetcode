package ValidNumber;

/**
 * Created by Alan on 11/8/14.
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(isNumber("3"));
    }

    public static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'A') {
                return false;
            }
        }
        String[] ss = s.split(".");
        if (ss.length > 1) {
            if (ss[0].isEmpty() || ss[1].isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
