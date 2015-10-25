package CountCompleteTreeNodes;

/**
 * Created by Alan on 8/23/15.
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode tmp = root.left;
        int leftHeight = 1;
        while (tmp != null) {
            tmp = tmp.left;
            leftHeight++;
        }
        tmp = root.right;
        int rightHeight = 1;
        while (tmp != null) {
            tmp = tmp.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight)
            return (2 << (leftHeight - 1)) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
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
