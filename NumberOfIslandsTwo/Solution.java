package NumberOfIslandsTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 1/2/2016.
 */
public class Solution {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        List<Integer> result = new ArrayList<>();

        int count = 0;

        int[] diffX = {0, 0, 1, -1};
        int[] diffY = {1, -1, 0, 0};

        for (int[] position : positions) {
            roots[position[0] * n + position[1]] = position[0] * n + position[1];
            count++;
            for (int i = 0; i < 4; i++) {
                int neighborX = position[0] + diffX[i];
                int neighborY = position[1] + diffY[i];
                if (neighborX >= 0 && neighborX < m
                        && neighborY >= 0 && neighborY < n
                        && roots[neighborX * n + neighborY] != -1) {
                    int rootNeighbor = find(neighborX * n + neighborY, roots);
                    int rootNew = roots[position[0] * n + position[1]];
                    if (rootNeighbor != rootNew) {
                        count--;
                    }
                    roots[rootNeighbor] = rootNew;
                }
            }
            result.add(count);
        }
        return result;
    }

    private int find(int r, int[] roots) {
        int root = roots[r];
        if (root == r) {
            return root;
        }
        return find(root, roots);
    }
}
