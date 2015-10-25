package FlattenBinaryTreeToLinkedList;

/**
 * Created by Alan on 8/2/15.
 */

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        // recursion
//        if (root == null) {
//            return;
//        }
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//
//        root.left = null;
//
//        flatten(left);
//        flatten(right);
//
//        root.right = left;
//        TreeNode cur = root;
//        while (cur.right != null) {
//            cur = cur.right;
//        }
//        cur.right = right;

        // iterative
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        if(root.right!=null){
            stack.push(root.right);
        }
        if(root.left!=null){
            stack.push(root.left);
        }

        TreeNode cur = root;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            cur.left = null;
            cur.right = node;
            cur = node;
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
