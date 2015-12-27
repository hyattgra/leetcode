package FlipGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 12/27/2015.
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        char[] chars = s.toCharArray();
        List<String> ret = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (chars[i - 1] == '+' && chars[i] == '+') {
                chars[i - 1] = '-';
                chars[i] = '-';
                ret.add(new String(chars));
                chars[i - 1] = '+';
                chars[i] = '+';
            }
        }
        return ret;
    }
}
