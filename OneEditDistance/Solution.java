package OneEditDistance;

/**
 * Created by Alan on 9/27/2015.
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if (slen > tlen) {
            return isOneEditDistance(t, s);
        }

        if (tlen - slen > 1) {
            return false;
        }
        int i = 0;
        while (i < slen) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i).equals(t.substring(i + 1)) ||
                        s.substring(i + 1).equals(t.substring(i + 1));
            }
            i++;
        }
        return slen + 1 == tlen;
    }

}
