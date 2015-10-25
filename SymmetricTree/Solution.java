package SymmetricTree;

/**
 * Created by Alan on 7/27/15.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSys(root.left, root.right);

    }

    private boolean isSys(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        return isSys(node1.left, node2.right) && isSys(node1.right, node2.left);

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