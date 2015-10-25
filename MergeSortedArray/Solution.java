package MergeSortedArray;

/**
 * Created by Alan on 11/9/14.
 */
public class Solution {
    public static void main(String[] args) {

        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        merge(A, 3, B, 3);
        for (int i : A) {
            System.out.println(i);
        }


    }

    public static void merge(int A[], int m, int B[], int n) {
        while (m + n > 0 && n != 0) {
            A[m + n -1] = (m < 1 || A[m - 1] <= B[n - 1]) ?
                    B[(n--)-1] : A[(m--)-1];
        }
    }
}
