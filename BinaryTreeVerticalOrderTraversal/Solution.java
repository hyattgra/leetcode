package BinaryTreeVerticalOrderTraversal;

import java.util.*;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        queue.add(root);
        colQueue.add(0);
        int left = 0;
        int right = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = colQueue.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                colQueue.add(col - 1);
                left = Math.min(left, col - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                colQueue.add(col + 1);
                right = Math.max(right, col + 1);
            }
        }
        for (int i = left; i <= right; i++) {
            ret.add(map.get(i));
        }
        return ret;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
