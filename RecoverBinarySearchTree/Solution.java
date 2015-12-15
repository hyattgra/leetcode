package RecoverBinarySearchTree;

/**
 * Created by Alan on 12/14/2015.
 */
public class Solution {
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }
        dfs(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
            }
            if (first != null) {
                second = root;
            }
        }
        pre = root;
        if (root.right != null) {
            dfs(root.right);
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
}
