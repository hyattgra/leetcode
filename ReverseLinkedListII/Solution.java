package ReverseLinkedListII;

/**
 * Created by Alan on 8/11/15.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode tnode = cur.next;
            cur.next = tnode.next;
            tnode.next = pre.next;
            pre.next = tnode;
        }
        return dummy.next;
    }


}
