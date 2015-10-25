package PathSum;

/**
 * Created by Alan on 7/26/15.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
            return true;
        }
        return false;
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
