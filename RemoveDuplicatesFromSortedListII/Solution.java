package RemoveDuplicatesFromSortedListII;

/**
 * Created by Alan on 8/8/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                while (cur.next.next != null && cur.next.val == cur.next.next.val) {
                    cur.next.next = cur.next.next.next;
                }
                cur.next = cur.next.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
