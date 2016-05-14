package RangeSumQueryMutable;

/**
 * Created by Alan on 5/14/2016.
 */
public class NumArray {

    int[] sums = null;
    int[] localNums = null;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        localNums = nums;
        for (int i = 0; i < localNums.length; i++) {
            updateHelper(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int delta = val - localNums[i];
        for (int j = i + 1; j < localNums.length + 1; j += j & -j) {
            sums[j] += delta;
        }
        localNums[i] = val;
    }

    public void updateHelper(int i, int val) {
        i++;
        while (i <= localNums.length) {
            sums[i] += val;
            i += (i & -i);
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }

    private int getSum(int i) {
        int ret = 0;

        while (i > 0) {
            ret += sums[i];
            i -= i & (-i);
        }
        return ret;
    }
}
