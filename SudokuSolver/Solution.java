package SudokuSolver;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean solveSudoku(char[][] board) {
        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = (char) (k + '0');
                        if (isValid(board, i, j) && solveSudoku(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int x, int y) {
        int height = board.length;
        int width = board[0].length;

        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == board[x][y]) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (j != y && board[x][j] == board[x][y]) {
                return false;
            }
        }

        for (int m = 3 * (x / 3); m < 3 * (x / 3) + 3; m++) {
            for (int n = 3 * (x / 3); n < 3 * (y / 3) + 3; n++) {
                if (m != x && n != y && board[m][n] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

}
