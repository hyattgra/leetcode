package BinaryTreeMaximumPathSum;

/**
 * Created by Alan on 12/15/2015.
 */
public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        calculate(root);
        return max;
    }

    private int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(calculate(root.left), 0);
        int rightMax = Math.max(calculate(root.right), 0);

        max = Math.max(max, leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax, rightMax);
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
