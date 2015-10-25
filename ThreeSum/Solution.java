package ThreeSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        int[] S = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = threeSum(S);
        for (List<Integer> t : ret) {
            for (Integer tt : t) {
                System.out.print(tt + " ");
            }
            System.out.println(" ");
        }

    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(num);

        int right = num.length - 1;


        for (int i = 0; i < right - 1; i++) {

            for (int j = i + 1, k = right; j < k; ) {
                int a = num[i];
                int b = num[j];
                int c = num[k];

                if (a + b + c == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    result.add(temp);
//                    System.out.print("test : "+ i + " " + j + " " + k + " end test");
                    j++;
                    k--;
                }
                if (a + b + c > 0) {
                    k--;
                }
                if (a + b + c < 0) {
                    j++;
                }
            }
        }

        for (int i = result.size() - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (result.get(i).get(0) == result.get(j).get(0)
                        && result.get(i).get(1) == result.get(j).get(1)
                        && result.get(i).get(2) == result.get(j).get(2)) {
                    result.remove(j);
                    i--;
                }
            }
        }


        return result;


    }

}
