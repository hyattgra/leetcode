package ValidAnagram;

/**
 * Created by Alan on 8/16/15.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[256];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (char sc : ss) {
            count[sc] += 1;
        }
        for (char tc : tt) {
            count[tc] -= 1;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
