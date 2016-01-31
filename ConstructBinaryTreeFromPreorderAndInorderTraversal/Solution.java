package ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 8/2/15.
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        //initialize inorder map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder,0,preorder.length-1, inorder, 0, inorder.length-1,map);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = map.get(root.val);
        root.left = build(preorder, preLeft + 1, preLeft + rootIndex - inLeft, inorder, inLeft, rootIndex - 1, map);
        root.right = build(preorder, preLeft + rootIndex - inLeft + 1, preRight, inorder, rootIndex + 1, inRight, map);

        return root;
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
