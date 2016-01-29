package InorderSuccessorInBST;

/**
 * Created by Alan on 1/28/2016.
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ret = null;
        while (root != null) {
            if (root.val > p.val) {
                ret = root;
                root = root.left;
            } else {
                root = root.right;
            }
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
