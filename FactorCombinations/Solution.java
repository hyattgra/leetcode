package FactorCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 9/27/15.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(ret, tmp, n, 2);
        return ret;
    }

    private void helper(List<List<Integer>> ret, List<Integer> tmp, int n, int start) {
        if (n <= 1) {
            // avoid [[]]
            if (tmp.size() > 1) {
                ret.add(new ArrayList<Integer>(tmp));
            }
        }
        for (int i = start; i <= n; i++) {
            if(n % i ==0){
                tmp.add(i);
                helper(ret, tmp, n / i, i);
                tmp.remove(tmp.size()-1);
            }
        }

    }
}
