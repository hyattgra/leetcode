package SearchInsertPosition;

/**
 * Created by Alan on 10/20/14.
 */
public class Solution {
    public static void main(String[] args) {

        int[] A = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(A, target));

    }

    public static int searchInsert(int[] A, int target) {

//        return search(A, 0, A.length - 1, target);
        return search(A,target);
    }

    public static int search(int[] A, int l, int r, int target) {
        if (l > r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (A[mid] < target) {
            return search(A, mid + 1, r, target);
        } else if (A[mid] > target) {
            return search(A, l, mid - 1, target);
        }
        return mid;
    }

    public static int search(int[] A, int target){
        int l = 0;
        int r = A.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(A[mid] > target){
                r = mid-1;
            }else if(A[mid] < target){
                l = mid +1;
            }else{
                return mid;
            }
        }

        return l;
    }
}
