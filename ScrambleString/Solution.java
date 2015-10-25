package ScrambleString;

import java.util.Arrays;

/**
 * Created by Alan on 9/1/15.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] as1 = s1.toCharArray();
        char[] as2 = s2.toCharArray();
        Arrays.sort(as1);
        Arrays.sort(as2);
        if (!Arrays.equals(as1, as2)) {
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) {
                return true;
            }
        }
        return false;
    }
}
