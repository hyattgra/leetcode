package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 8/12/15.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        build(ret, 0, root);
        return ret;
    }

    private void build(List<List<Integer>> ret, int n, TreeNode node) {
        if (node == null) {
            return;
        }
        if (n >= ret.size()) {
            ret.add(new ArrayList<>());
        }
        if (n % 2 == 1) {
            ret.get(n).add(0, node.val);
        }
        if (n % 2 == 0) {
            ret.get(n).add(node.val);
        }
        build(ret, n + 1, node.left);
        build(ret, n + 1, node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
