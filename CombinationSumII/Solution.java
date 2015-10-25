package CombinationSumII;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gzhou on 5/29/15.
 */
public class Solution {

    private static void search(int[] candidates, int start, int target, int currentSum, List<List<Integer>> result, List<Integer> currentResult) {
        if (currentSum == target) {
            ArrayList<Integer> tmpRes = new ArrayList<Integer>(currentResult);
            result.add(tmpRes);
            return;
        }
        if (currentSum < target) {
            for (int i = start; i < candidates.length && start < candidates.length; i++) {
                currentSum += candidates[i];
                currentResult.add(candidates[i]);
                search(candidates, i + 1, target, currentSum, result, currentResult);
                currentSum -= candidates[i];
                currentResult.remove(currentResult.size() - 1);
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
            return ;
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> currentRes = new ArrayList<Integer>();
        search(candidates, 0, target, 0, res, currentRes);
        return res;
    }
}
