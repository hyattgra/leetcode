package SearchforaRange;

/**
 * Created by Alan on 10/20/14.
 */
public class Solution {
    public static void main(String[] args) {

//        int[] A = {5,7,7,8,8,10};
        int[] A = {};
        int[] re = searchRange(A, 11);
        System.out.println(re[0]);
        System.out.println(re[1]);

    }

    public static int[] searchRange(int[] A, int target) {
        int[] re = {-1, -1};
        if (A == null || A.length == 0) {
            return re;
        }

        int ll = 0;
        int lr = A.length - 1;
        while (ll <= lr) {
            int mid = ll + (lr - ll) / 2;
            if (A[mid] < target) {
                ll = mid + 1;
            } else {
                lr = mid - 1;
            }
        }

        int rl = 0;
        int rr = A.length-1;
        while(rl <=rr){
            int mid = rl + (rr - rl) / 2;
            if (A[mid] <= target) {
                rl = mid + 1;
            } else {
                rr = mid - 1;
            }
        }

        if(ll<=rr){
            re[0] = ll;
            re[1] = rr;
        }

        return re;
    }
}
