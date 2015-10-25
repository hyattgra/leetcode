package GraphValidTree;

/**
 * Created by gzhou on 9/30/15.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }
        if (edges == null || edges.length != n - 1) {
            return false;
        }

        int[] union = new int[n];

        for (int i = 0; i < n; i++) {
            union[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (find(union, x) == find(union, y)) {
                return false;
            }
            union[y] = x;
        }
        return true;
    }

    private int find(int[] union, int x) {
        while (union[x] != x) {
            x = union[x];
        }
        return x;
    }
}
