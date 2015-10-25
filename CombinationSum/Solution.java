package CombinationSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 3/15/15.
 */
public class Solution {

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
//        List<List<Integer>> ret = new ArrayList<>();
//        ret = combinationSum(candidates, 7);
//        for (List<Integer> ss : ret) {
//            for (Integer r : ss) {
//                System.out.println(r + " ");
//            }
//            System.out.println();
//        }

    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, path, ret, 0);
        return ret;
    }

    public static void dfs(int[] candidates, int target, ArrayList<Integer> path, List<List<Integer>> ret, int idx) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int candidate = candidates[i];
            path.add(candidate);
            dfs(candidates, target - candidate, path, ret, i);
            path.remove(path.size() - 1);
        }
    }
}
