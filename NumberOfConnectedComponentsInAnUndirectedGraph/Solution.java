package NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 1/2/2016.
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();


    public int countComponents(int n, int[][] edges) {

        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }
        int ret = n;
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (union(x, y)) {
                ret--;
            }
        }
        return ret;
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }
        map.put(rootY, rootX);
        return true;
    }

    private int find(int x) {
        int rootX = map.get(x);
        if (rootX == x) {
            return x;
        }

        return find(rootX);
    }
}
