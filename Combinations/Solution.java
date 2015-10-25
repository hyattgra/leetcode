package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> ret = combine(4, 2);
        for (List<Integer> row : ret) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("---------");
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        combination(ret, tmp, 1, n, k);
        return ret;
    }

    private static void combination(List<List<Integer>> ret, List<Integer> tmp, int start, int n, int k) {
        if (k == 0) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(tmp);
            ret.add(newList);
            return;
        }

        // important j
        int j = 1;
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            combination(ret, tmp, start + j, n, k - 1);
            tmp.remove(tmp.size() - 1);
            j++;
        }
    }
}
