package BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 8/23/15.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root != null) {
            traverse(root, ret, "");
        }
        return ret;
    }

    private void traverse(TreeNode node, List<String> ret, String tmp) {
        if (node == null) {
            return;
        }
        if (tmp.isEmpty()) {
            tmp += node.val;
        } else {
            tmp += "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            ret.add(tmp);
        }else{
            traverse(node.left, ret, tmp);
            traverse(node.right, ret, tmp);
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
