package PopulatingNextRightPointersInEachNodeII;

/**
 * Created by Alan on 8/29/15.
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode tmp = cur;
            while (tmp != null) {
                if (tmp.left != null) {
                    tmp.left.next = tmp.right != null ? tmp.right : getNext(tmp);
                }

                if (tmp.right != null) {
                    tmp.right.next = getNext(tmp);
                }

                tmp = tmp.next;
            }
            if (cur.left != null) {
                cur = cur.left;
            } else if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = getNext(cur);
            }
        }
    }

    private TreeLinkNode getNext(TreeLinkNode node) {
        TreeLinkNode next = node.next;

        while (next != null) {
            if (next.left != null) {
                return next.left;
            }
            if (next.right != null) {
                return next.right;
            }
            next = next.next;
        }

        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
