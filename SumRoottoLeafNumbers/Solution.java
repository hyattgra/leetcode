package SumRoottoLeafNumbers;

import java.util.List;

/**
 * Created by Alan on 11/23/14.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {

        return 0;
    }

    public int dfs(TreeNode root, int pre) {

        if (root != null) {
            return 0;
        }
        int x = 10 * pre + root.val;
        if (root.left == null && root.right == null) {
            return x;
        }
        return dfs(root.left, x) + dfs(root.right, x);
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
