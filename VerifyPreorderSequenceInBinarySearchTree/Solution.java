package VerifyPreorderSequenceInBinarySearchTree;

import java.util.Stack;

/**
 * Created by Alan on 12/27/2015.
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int lowerBound = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (Integer i : preorder) {
            if (i < lowerBound) {
                return false;
            }
            while (!stack.isEmpty() && i > stack.peek()) {
                lowerBound = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}
