package BalancedBinaryTree;

/**
 * Created by Alan on 9/7/14.
 */
public class BBT {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.right) && isBalanced(root.left);

    }

    public int depth(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(depth(t.right), depth(t.left));
    }
}
