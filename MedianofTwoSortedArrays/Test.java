package MedianofTwoSortedArrays;

/**
 * Created by Alan on 9/9/14.
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1};
        Test t = new Test();
        System.out.print(t.find(a, b));
    }


    public double find(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if ((n + m) % 2 == 0) {
            return (findmedian(A, 0, m, B, 0, n, (m + n) / 2) + findmedian(A, 0,
                    m, B, 0, n, (m + n) / 2 + 1)) / 2.0;
        } else
            return findmedian(A, 0, m, B, 0, n, (m + n) / 2 + 1);
    }

    public double findmedian(int[] A, int as, int ae, int[] B, int bs, int be, int k) {

        int lenA = ae - as;// lenA is not actual the len of array A;
        int lenB = be - bs;

        if (lenA <= 0) {
            return B[bs + k - 1];
        }
        if (lenB <= 0) {
            return A[as + k - 1];
        }

        if (k == 0) {
            return A[as] < B[bs] ? A[as] : B[bs];
        }

        if (A[as + lenA / 2] <= B[bs + lenB / 2]) {
            if (lenA / 2 + lenB / 2 + 1 >= k) {
                return findmedian(A, as, ae, B, bs, bs + lenB / 2, k);
            } else {
                return findmedian(A, as + lenA / 2 + 1, ae, B, bs, be, k - lenA / 2 - 1);
            }
        } else {
            if (lenA / 2 + lenB / 2 + 1 >= k) {
                return findmedian(A, as, as + lenA / 2, B, bs, be, k);
            } else {
                return findmedian(A, as, ae, B, bs + lenB / 2 + 1, be, k - lenB / 2 - 1);
            }
        }
    }


}
