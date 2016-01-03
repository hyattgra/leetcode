package UglyNumberTwo;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        Queue<Long> queue = new PriorityQueue<>();
        Long ret = 1L;
        queue.offer(ret);
        int[] nums = {2, 3, 5};

        for (int i = 0; i < n; i++) {

            ret = queue.poll();

            for (int num : nums) {
                Long val = ret * num;
                if (!queue.contains(val)) {
                    queue.offer(val);
                }
            }
        }

        return ret.intValue();
    }
}
