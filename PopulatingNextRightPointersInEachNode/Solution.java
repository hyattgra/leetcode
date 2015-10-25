package PopulatingNextRightPointersInEachNode;

/**
 * Created by Alan on 7/26/15.
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        // recursion version
//        if (root == null || root.left == null) {
//            return;
//        }
//
//        root.left.next = root.right;
//        root.right.next = root.next == null ? null : root.next.left;
//
//        connect(root.left);
//
//        connect(root.right);

        // constant space
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        while (cur != null && cur.left != null) {
            TreeLinkNode tmp = cur;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                tmp.right.next = tmp.next == null ? null : tmp.next.left;
                tmp = tmp.next;
            }
            cur = cur.left;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

}
