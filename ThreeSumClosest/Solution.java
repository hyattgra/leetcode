package ThreeSumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 9/23/14.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();

    }

    public void test() {
        int[] S = {1, 1, 1, 0};
        int ret = threeSumClosest(S, 100);
        System.out.println(ret);

    }

    public int threeSumClosest(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(num);

        int right = num.length - 1;

        int re = num[0] + num[1] + num[2];
        for (int i = 0; i < right - 1; i++) {
            int j = i + 1;
            int k = right;
            while (j < k) {
                int a = num[i];
                int b = num[j];
                int c = num[k];
                int sum = a + b + c;
                if (Math.abs(target - re) > Math.abs(target - sum)) {
                    re = sum;
                    if (re == target) {
                        return re;
                    }
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return re;


    }
}
