package ValidateBinarySearchTree;

/**
 * Created by Alan on 11/9/14.
 */
public class Solution {
    public static void main(String[] args) {

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isValidBST(TreeNode root) {

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode r, int min, int max) {
        if (r == null) {
            return true;
        }
        if (r.val > max || r.val < min) {
            return false;
        }
        return isValid(r.left, min, r.val - 1) && isValid(r.right, r.val + 1, max);

    }


}
