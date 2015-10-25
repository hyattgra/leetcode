package ContainsDuplicateII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alan on 8/16/15.
 */
public class Solution {
    public static void main(String[] args) {
        int[] test = {-1, -1};
        System.out.print(containsNearbyDuplicate(test, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> l = map.get(nums[i]);
                l.add(i);
                map.put(nums[i], l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
