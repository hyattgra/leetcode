package ClosestBinarySearchTreeValue;

/**
 * Created by gzhou on 9/24/15.
 */
public class Solution {

    public int closestValue(TreeNode root, double target) {
        int cloestValue = root.val;
        while (root != null) {
            cloestValue = Math.abs(root.val-target)<Math.abs(cloestValue-target)? root.val : cloestValue;
            if(cloestValue == target){
                return cloestValue;
            }
            root = root.val > target ? root.left : root.right;
        }
        return cloestValue;
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
