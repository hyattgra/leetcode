package LargestBSTSubtree;

/**
 * Created by Alan on 3/5/2016.
 */
public class Solution {

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + count(root.left) + count(root.right);
    }

    private boolean isValid(TreeNode r, int min, int max) {
        if (r == null) {
            return true;
        }
        if (r.val > max || r.val < min) {
            return false;
        }
        return isValid(r.left, min, r.val - 1) && isValid(r.right, r.val + 1, max);

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
