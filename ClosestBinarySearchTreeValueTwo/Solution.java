package ClosestBinarySearchTreeValueTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> successors = new Stack<>();
        Stack<TreeNode> predecessors = new Stack<>();

        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > target) {
                successors.push(cur);
                cur = cur.left;
            } else {
                predecessors.push(cur);
                cur = cur.right;
            }
        }

        while (k != 0) {
            if (successors.isEmpty() && predecessors.isEmpty()) {
                break;
            } else if (successors.isEmpty()) {
                ret.add(getPredecessor(predecessors));
            } else if (predecessors.isEmpty()) {
                ret.add(getSuccessor(successors));
            } else if (Math.abs(target - predecessors.peek().val) < Math.abs(successors.peek().val - target)) {
                ret.add(getPredecessor(predecessors));
            } else {
                ret.add(getSuccessor(successors));
            }
            k--;
        }

        return ret;
    }

    private int getPredecessor(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        TreeNode right = node.left;
        while (right != null) {
            stack.push(right);
            right = right.right;
        }
        return node.val;
    }

    private int getSuccessor(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        return node.val;
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
