package DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 9/2/15.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' ||
                c == '-' ||
                c == '*') {
                List<Integer> ret1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> ret2 = diffWaysToCompute(input.substring(i + 1));
                for (Integer p1 : ret1) {
                    for (Integer p2 : ret2) {
                        int tmp = 0;
                        if (c == '+') {
                            tmp = p1 + p2;
                        } else if (c == '-') {
                            tmp = p1 - p2;
                        } else if (c == '*') {
                            tmp = p1 * p2;
                        }
                        ret.add(tmp);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
