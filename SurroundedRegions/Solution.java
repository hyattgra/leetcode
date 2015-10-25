package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alan on 12/11/14.
 */
public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board == null) {
            return;
        }

        int height = board.length;
        int width = board[0].length;

        Queue<Integer> rowQueue = new LinkedList<Integer>();
        Queue<Integer> colQueue = new LinkedList<Integer>();

        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                rowQueue.offer(i);
                colQueue.offer(0);
            }
            if (board[i][width - 1] == 'O') {
                rowQueue.offer(i);
                colQueue.offer(width - 1);
            }
        }

        for (int j = 0; j < width; j++) {
            if (board[0][j] == 'O') {
                rowQueue.offer(0);
                colQueue.offer(j);
            }
            if (board[height - 1][j] == 'O') {
                rowQueue.offer(height - 1);
                colQueue.offer(j);
            }
        }

        while (!rowQueue.isEmpty()) {
            int row = rowQueue.poll();
            int col = colQueue.poll();
            board[row][col] = '#';

            if (row >= 1 && board[row - 1][col] == 'O') {
                rowQueue.offer(row - 1);
                colQueue.offer(col);
            }

            if (row < height-1 && board[row + 1][col] == 'O') {
                rowQueue.offer(row + 1);
                colQueue.offer(col);
            }

            if (col >= 1 && board[row][col - 1] == 'O') {
                rowQueue.offer(row);
                colQueue.offer(col - 1);
            }

            if (col < width-1 && board[row][col + 1] == 'O') {
                rowQueue.offer(row);
                colQueue.offer(col + 1);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }


}
