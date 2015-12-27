package FlipGameTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 12/27/2015.
 */
public class Solution {
    public boolean canWin(String s) {
        List<String> SS = generateNextMoves(s);
        for (String nextString : SS) {
            if (!canWin(nextString)) {
                return true;
            }
        }
        return false;
    }

    private List<String> generateNextMoves(String s) {
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                ret.add(s.substring(0, 1) + "--" + s.substring(i + 2, s.length()));
            }
        }
        return ret;
    }
}
