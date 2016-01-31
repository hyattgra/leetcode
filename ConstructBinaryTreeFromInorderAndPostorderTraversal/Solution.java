package ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 1/31/2016.
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        //initialize inorder map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] postorder, int postLeft, int postRight,
                           int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int rootIndex = map.get(root.val);

        root.left = build(postorder, postLeft, postLeft + rootIndex - inLeft - 1, inorder, inLeft, rootIndex - 1, map);
        root.right = build(postorder, postLeft + rootIndex - inLeft, postRight - 1, inorder, rootIndex + 1, inRight, map);

        return root;
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
