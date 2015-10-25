package CombinationSumIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 8/30/15.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currentRes = new ArrayList<Integer>();
        search(k, n, 1, res, currentRes);
        return res;
    }

    private void search(int k, int target, int start, List<List<Integer>> ret, List<Integer> tmp) {
        if (k == 0 && target == 0) {
            ret.add(new ArrayList(tmp));
            return;
        }
        if (k == 0 || target <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            tmp.add(i);
            search(k - 1, target - i, i + 1, ret, tmp);
            tmp.remove(tmp.size() - 1);
        }
        return;
    }
}
