package RemoveElement;

/**
 * Created by Alan on 10/10/14.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();

    }

    public void test() {
        int[] A = {1,2,3,4,4,4,5,1,2,1,0,12};
//        int[] A = {};

        int re = removeElement(A, 12);
        System.out.println(re);
    }

    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int i = 0;
        int j = -1;

        while (i < len) {
            if (A[i] != elem) {
                j++;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            i++;
        }

        return j + 1;
    }

}
