package RemoveDuplicatesfromSortedArray;

/**
 * Created by Alan on 10/10/14.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();

    }

    public void test() {
//        int[] A = {1,1,2,2,3,4,4,5,6,7,8,9};
        int[] A = {1,1,1,1,1,1,1};
        int re = removeDuplicates(A);
        System.out.println(re);
    }


    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 1; i < len; i++) {
            if (A[i] != A[num]) {
                num++;
                A[num] = A[i];
            }
        }
        return num + 1;
    }

}

