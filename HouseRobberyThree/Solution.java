package HouseRobberyThree;

/**
 * Created by Alan on 5/4/2016.
 */

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ret = helper(root);

        return Math.max(ret[0], ret[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] current = new int[2];
        current[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        current[1] = root.val + left[0] + right[0];

        return current;
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