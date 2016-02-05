package CountUnivalueSubtrees;


/**
 * Created by Alan on 10/17/15.
 */
public class Solution {

    public int countUnivalSubtrees(TreeNode root) {
//        int[] count = new int[1];
//        if (root == null) {
//            return 0;
//        }
//        countSubtree(count, root, root.val);
//        return count[0];
        int[] count = new int[1];
        countSub(root, count);
        return count[0];
    }

    private boolean countSub(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }

        boolean left = countSub(root.left, count);
        boolean right = countSub(root.right, count);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
//    private boolean countSubtree(int[] count, TreeNode root, int val) {
//
//        if (root == null) {
//            return true;
//        }
//
//        boolean left = countSubtree(count, root.left, root.val);
//        boolean right = countSubtree(count, root.right, root.val);
//
//        if (left && right) {
//            count[0]++;
//        }
//
//        return left && right && root.val == val;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
