package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Alan on 7/26/15.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // recursion
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        res.add(root.val);
//        res.addAll(preorderTraversal(root.left));
//        res.addAll(preorderTraversal(root.right));

        // iteration
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
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
