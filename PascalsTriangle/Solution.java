package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzhou on 8/3/15.
 */
public class Solution {
    public static void main(String[] args) {

//        List<List<Integer>> ret = generate(5);
//        for (List<Integer> row : ret) {
//            for (Integer i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            int n = i + 1;
            List<Integer> tmp = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                if (j == n - 1 || j == 0) {
                    tmp.add(1);
                } else {
                    tmp.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
