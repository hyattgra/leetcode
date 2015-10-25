package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 8/11/15.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int n) {
        List<TreeNode> ret = new ArrayList<>();

        if (start > n) {
            ret.add(null);
            return ret;
        }

        for (int i = start; i <= n; i++) {
            List<TreeNode> retLeft = generate(start, i - 1);
            List<TreeNode> retRight = generate(i + 1, n);

            for (TreeNode l : retLeft) {
                for (TreeNode r : retRight) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        return ret;
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
