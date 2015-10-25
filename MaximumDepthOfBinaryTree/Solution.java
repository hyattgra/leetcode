package MaximumDepthOfBinaryTree;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
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
