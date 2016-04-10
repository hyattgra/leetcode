package MinimumHeightTrees;

import java.util.*;

/**
 * Created by Alan on 4/10/2016.
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaf = new ArrayList<>();
            for (int leaf : leaves) {
                int to = adj.get(leaf).iterator().next();
                adj.get(to).remove(leaf);
                if (adj.get(to).size() == 1) {
                    newLeaf.add(to);
                }
            }

            leaves = newLeaf;
        }

        return leaves;
    }
}
