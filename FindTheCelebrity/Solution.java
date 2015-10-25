package FindTheCelebrity;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Alan on 9/10/15.
 */
public class Solution {
    public int findCelebrity(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int candidate = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }

    private boolean knows(int a, int b) {
        return true;
    }
}
