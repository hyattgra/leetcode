package SearchA2DMatrix;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    //    public boolean searchMatrix(int[][] matrix, int target) {
//
//        for (int i = 0; i < matrix.length-1; i++) {
//            if(matrix[i][0] <= target && target <= matrix[i+1][0]){
//                return binarySearch(matrix[i], target);
//            }
//        }
//        return false;
//    }
//
//    private boolean binarySearch(int[] row, int target) {
//        int right = row.length - 1;
//        int left = 0;
//        while (left <= right) {
//            if (row[(right - left) / 2] > target) {
//                right = (right - left) / 2;
//            } else {
//                left = (right - left) / 2;
//            }
//        }
//
//        return row[(right - left) / 2] == target;
//    }
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            }else if(matrix[i][j] < target){
                j++;
            }
        }
        return false;
    }

}
