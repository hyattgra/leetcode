package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Alan on 7/27/15.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);

        System.out.print(levelOrderBottom(node));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        int depth = height(root);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            ret.add(new ArrayList<>());
        }

        if (depth == 0) {
            return ret;
        }
        dfs(ret, ret.size() - 1, root);
        return ret;
    }

    private static void dfs(List<List<Integer>> ret, int level, TreeNode node) {
        if (node == null) {
            return;
        }

        ret.get(level).add(node.val);
        dfs(ret, level - 1, node.left);
        dfs(ret, level - 1, node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
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
