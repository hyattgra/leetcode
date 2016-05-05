package CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 5/4/2016.
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]);
        }
        Integer[] ret = new Integer[nums.length];
        int[] tree = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = sum(tree, nums[i]);
            update(tree, nums[i] + 1, 1);
        }

        return Arrays.asList(ret);

    }

    private void update(int[] tree, int index, int val) {

        while (index < tree.length) {
            tree[index] += val;
            index += index & -index;
        }

    }

    private int sum(int[] tree, int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}
