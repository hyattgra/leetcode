package WallsAndGates;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {

    private int[][] diff = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, rooms.length, rooms[0].length);
                }
            }
        }

    }

    private void dfs(int[][] rooms, int i, int j, int m, int n) {
        int dist = rooms[i][j];
        for (int[] di : diff) {
            int newX = i + di[0];
            int newY = j + di[1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || rooms[newX][newY] <= dist) continue;
            rooms[newX][newY] = dist + 1;
            dfs(rooms, newX, newY, m, n);
        }
    }

}
