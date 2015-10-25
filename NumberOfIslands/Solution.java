package NumberOfIslands;

/**
 * Created by Alan on 8/31/15.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    search(grid, i, j);
                }
            }
        }
        return count;
    }

    private void search(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j]=='0') {
            return;
        }
        grid[i][j] = '0';
        search(grid, i + 1, j);
        search(grid, i - 1, j);
        search(grid, i, j + 1);
        search(grid, i, j - 1);
    }
}
