package NQueens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 1/16/15.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        solve(n, 0, new int[n], ret);
        return ret;

    }

    public void solve(int n, int row, int[] colForRow, ArrayList<String[]> ret) {

        if (row == n) {
            String[] tmpRes = new String[n];

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (colForRow[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                tmpRes[i] = sb.toString();
            }

            ret.add(tmpRes);
            return;
        }

        for (int i = 0; i < n; i++) {
            colForRow[row] = i;
            if (isValid(row, colForRow)) {
                solve(n, row + 1, colForRow, ret);
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