package PathSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzhou on 8/4/15.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        find(ret, tmp, root, sum);
        return ret;
    }

    private void find(List<List<Integer>> ret, List<Integer> tmp, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        tmp.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            List<Integer> tp = new ArrayList<>(tmp);
            ret.add(tp);
        }
        find(ret, tmp, node.left, sum - node.val);
        find(ret, tmp, node.right, sum - node.val);
        tmp.remove(tmp.size() - 1);

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
