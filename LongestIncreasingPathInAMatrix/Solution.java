package LongestIncreasingPathInAMatrix;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {

    private static final int[] diffX = {1, -1, 0, 0};
    private static final int[] diffY = {0, 0, 1, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] cache = new int[rowLen][colLen];
        int max = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                max = Math.max(max, dfs(matrix, i, j, rowLen, colLen, cache));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int x, int y, int m, int n, int[][] cache) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + diffX[i];
            int newY = y + diffY[i];

            if (newX >= 0 && newY >= 0 && newX < m && newY < n && matrix[newX][newY] > matrix[x][y]) {
                cache[x][y] = Math.max(cache[x][y], dfs(matrix, newX, newY, m, n, cache));
            }
        }

        return ++cache[x][y];
    }
}
