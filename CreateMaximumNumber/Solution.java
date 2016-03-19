package CreateMaximumNumber;

import java.util.Stack;

/**
 * Created by Alan on 3/17/2016.
 */


public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ret = new int[k];
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            int[] temp = merge(generateMaxSubArrary(nums1, i), generateMaxSubArrary(nums2, j));
            ret = isSmallerOrEqual(ret, temp) ? temp : ret;
        }
        return ret;
    }

    private static boolean isSmallerOrEqual(int[] A, int[] B) {
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length && A[i] == B[i]) {
            i++;
            j++;
        }

        return i == A.length || A[i] < B[j];
    }

    private static int[] merge(int[] A, int[] B) {
        int[] ret = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                ret[k++] = B[j++];
            } else {
                ret[k++] = A[i++];
            }
        }
        if (i == A.length) {
            while (j < B.length) {
                ret[k++] = B[j++];
            }
        }
        if (j == B.length) {
            while (i < A.length) {
                ret[k++] = A[i++];
            }
        }
        return ret;
    }

    private static int[] generateMaxSubArrary(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                stack.push(arr[i]);
            }
            if (arr.length - i < k) {
                stack.push(arr[i]);
            } else if (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
                stack.push(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[ret.length - i - 1] = stack.pop();
        }
        return ret;
    }
}
