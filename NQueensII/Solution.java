package NQueensII;

import java.util.ArrayList;

/**
 * Created by gzhou on 6/10/15.
 */
public class Solution {

    public int totalNQueens(int n) {

        int[] ret = new int[1];
        solve(n, 0, new int[n], ret);
        return ret[0];

    }

    public void solve(int n, int row, int[] colForRow, int[] ret) {
        if (row == n) {
            ret[0]++;
        } else {
            for (int i = 0; i < n; i++) {
                colForRow[row] = i;
                if (isValid(row, colForRow)) {
                    solve(n, row + 1, colForRow, ret);
                }
            }

        }
    }

    public boolean isValid(int row, int[] colForRow) {
        for (int i = 0; i < row; i++) {
            if (colForRow[row] == colForRow[i] || Math.abs(colForRow[row] - colForRow[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
