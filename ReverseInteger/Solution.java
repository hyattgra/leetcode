package ReverseInteger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alan on 9/20/14.
 */
public class Solution {

    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.test();
    }

    public void test() {
        int r = reverse(-100100);
        System.out.print(r);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int number = x < 0 ? -x : x;

        List<Integer> result = new LinkedList<Integer>();
        while (number > 0) {
            result.add(number % 10);
            number = number / 10;
        }

        int n = 0;

        while (result.get(n) == 0) {
            n++;
        }
        List<Integer> neresult = result.subList(n, result.size());

        int ret = 0;
        for (int j = 0; j < neresult.size(); j++) {
            ret += Math.pow(10, neresult.size() - j - 1) * neresult.get(j);
        }

        return x < 0 ? -ret : ret;

    }


}
