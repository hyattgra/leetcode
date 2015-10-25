package RotateImage;

/**
 * Created by Alan on 6/9/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[] r1 = {1, 2};
        int[] r2 = {3, 4};
        int[][] test = new int[2][2];
        test[0] = r1;
        test[1] = r2;
        rotate(test);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(" " + test[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        //(N+1)/2 to inclued the middle row if odd
        for (int i = 0; i < (N+1) / 2 ; i++) {
            for (int j = 0; j < N / 2 ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][i];
                matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
                matrix[j][N - i - 1] = tmp;
            }
        }
    }
}
