package StrobogrammaticNumberTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 1/1/2016.
 */
public class Solution {

    private int n;

    public List<String> findStrobogrammatic(int n) {
        this.n = n;
        List<String> ret = new ArrayList<>();
        helper(ret, "", "", n);
        return ret;
    }

    private void helper(List<String> list, String left, String right, int k) {
        if (k == 0) {
            list.add(left + right);
            return;
        }

        if (k == 1) {
            list.add(left + "0" + right);
            list.add(left + "1" + right);
            list.add(left + "8" + right);
            return;
        }

        if (k != n) {
            helper(list, left + "0", "0" + right, k - 2);
        }

        helper(list, left + "1", "1" + right, k - 2);
        helper(list, left + "6", "9" + right, k - 2);
        helper(list, left + "8", "8" + right, k - 2);
        helper(list, left + "9", "6" + right, k - 2);

    }
}
