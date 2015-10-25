package SameTree;

/**
 * Created by Alan on 8/1/15.
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return p == q;
        }
        if(p.val == q.val){
            if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
                return true;
            }
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
