package LowestCommonAncestorOfABinarySearchTree;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // would better keep in mind
        return ((p.val - root.val) * (q.val - root.val) <= 0) ?
                root :
                lowestCommonAncestor(p.val > root.val ? root.right : root.left, p, q);

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
