package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Alan on 8/29/15.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> ret = new ArrayList<>();
//        if (root == null) {
//            return ret;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode node = queue.poll();
//                if (i == len - 1) {
//                    ret.add(node.val);
//                }
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return ret;

        // recursion
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }

        helper(root, ret, 0);
        return ret;

    }

    private void helper(TreeNode node, List<Integer> ret, int height) {
        if (height == ret.size()) {
            ret.add(node.val);
        }

        if (node.right != null) {
            helper(node.right, ret, height + 1);
        }
        if (node.left != null) {
            helper(node.left, ret, height + 1);
        }
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
