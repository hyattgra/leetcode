package Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzhou on 6/5/15.
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        List<Integer> t1 = new ArrayList<Integer>();
        t1.add(-1);
        List<Integer> t2 = new ArrayList<Integer>();
        t2.add(2);
        t2.add(3);
        List<Integer> t3 = new ArrayList<Integer>();
        t3.add(1);
        t3.add(-1);
        t3.add(-3);
        test.add(t1);
        test.add(t2);
        test.add(t3);
        System.out.println(minimumTotal(test));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + dp[i][j] + " ");
            }
            System.out.println(" ");
        }


        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
//                int t1 = triangle.get(i + 1).get(j);
//                int t2 = triangle.get(i + 1).get(j + 1);
                int t1 = dp[i+1][j];
                int t2 = dp[i+1][j+1];
                dp[i][j] += Math.min(t1, t2);
            }
        }

        return dp[0][0];
    }

}
