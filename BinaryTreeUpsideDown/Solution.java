package BinaryTreeUpsideDown;

/**
 * Created by Alan on 9/10/15.
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode current = root;
        TreeNode parentRight = null;
        TreeNode parent = null;
        while (current != null) {
            TreeNode left = current.left;
            current.left = parentRight;
            parentRight = current.right;
            current.right = parent;
            parent = current;
            current = left;
        }
        return parent;
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
