package CountOfRangeSum;

import java.util.Arrays;

/**
 * Created by Alan on 3/28/2016.
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }

        return countRange(nums, 0, nums.length - 1, lower, upper);

    }

    private int countRange(int[] nums, int l, int h, int lower, int upper) {
        if (l == h) {
            return nums[l] >= lower && nums[h] <= upper ? 1 : 0;
        }

        int mid = l + (h - l) / 2;
        long[] arr = new long[h - mid];
        long sum = 0;
        for (int i = mid + 1; i <= h; i++) {
            sum += nums[i];
            arr[i - (mid + 1)] = sum;
        }

        Arrays.sort(arr);
        sum = 0;
        int count = 0;
        for (int i = mid; i >= l; i--) {
            sum += nums[i];
            count += binarySearch(arr, upper - sum + 0.5) - binarySearch(arr, lower - sum - 0.5);
        }
        return count + countRange(nums, l, mid, lower, upper) + countRange(nums, mid + 1, h, lower, upper);
    }


    private int binarySearch(long[] arr, double value) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }
}
