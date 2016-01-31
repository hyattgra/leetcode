package SerializeAndDeserializeBinaryTree;

import java.util.Scanner;

/**
 * Created by Alan on 1/31/2016.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "$";
        }

        return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return helper(new Scanner(data));

    }

    public TreeNode helper(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        }
        String next = sc.next();
        if (next.equals("$")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(next));

        root.left = helper(sc);
        root.right = helper(sc);

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
