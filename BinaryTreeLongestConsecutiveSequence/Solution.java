package BinaryTreeLongestConsecutiveSequence;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(dfs(root.left, 1, 1, root.val), dfs(root.right, 1, 1, root.val));

    }

    public int dfs(TreeNode root, int tmpLen, int ret, int parentVal) {
        if (root == null) {
            return ret;
        }

        if (root.val == parentVal + 1) {
            tmpLen++;
            ret = Math.max(ret, tmpLen);
        } else {
            tmpLen = 1;
        }

        return Math.max(dfs(root.left, tmpLen, ret, root.val), dfs(root.right, tmpLen, ret, root.val));
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

