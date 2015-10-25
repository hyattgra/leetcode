package KthLargestElementInAnArray;

/**
 * Created by Alan on 8/31/15.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        return partition(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private int partition(int[] nums, int k, int start, int end) {
        int lo = start;
        int hi = end;
        int pivot = nums[end];
        while (true) {
            while (nums[lo] < pivot && lo < hi) {
                lo++;
            }
            while (nums[hi] >= pivot && hi > lo) {
                hi--;
            }

            if (lo == hi) {
                break;
            }
            swap(nums, lo, hi);
        }

        swap(nums, lo, end);
        if (k == lo + 1) {
            return pivot;
        }
        if (k < lo + 1) {
            return partition(nums, k, start, lo - 1);
        }

        return partition(nums, k, lo + 1, end);

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
