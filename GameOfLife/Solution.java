package GameOfLife;

/**
 * Created by Alan on 12/10/2015.
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLives(board, m, n, i, j);

                // for other conditions, just retain the board's original states
                // like live, and neighbors < 2 or >3;
                // dead, and neighbors except ==3
                if ((board[i][j] & 1) == 1 && (lives >= 2 && lives <= 3)) {
                    board[i][j] = 3;
                }
                if ((board[i][j] & 1) == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int getLives(int[][] board, int m, int n, int x, int y) {
        int lives = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(m - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(n - 1, y + 1); j++) {
                lives += board[i][j] & 1;
            }
        }
        lives -= board[x][y] & 1;
        return lives;
    }

}
