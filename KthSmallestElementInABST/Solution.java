package KthSmallestElementInABST;

import java.util.Stack;

/**
 * Created by Alan on 8/30/15.
 */
public class Solution {

    public static int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        //iterative
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode node = root;
//        while (node != null) {
//            stack.push(node);
//            node = node.left;
//        }
//        int count = 0;
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            count++;
//            if (count == k) {
//                return cur.val;
//            }
//            TreeNode right = cur.right;
//            while (right != null) {
//                stack.push(right);
//                right = right.left;
//            }
//        }
//        return -1;
        count(root, k);
        return ans;
    }

    private int count(TreeNode node, int k) {
        if (node == null) {
            return 0;
        }
        int leftCount = count(node.left, k);
        int rightCount = count(node.right, k - leftCount - 1);
        if (k == leftCount + 1) {
            ans = node.val;
        }

        return leftCount + rightCount + 1;
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
