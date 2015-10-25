package InsertionSortList;

/**
 * Created by Alan on 7/26/15.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.next.val < cur.val) {
                // use pre to find the appropriate position for insertion
                ListNode pre = dummy;
                while (pre.next != null && pre.next.val < cur.next.val) {
                    pre = pre.next;
                }
                    ListNode tmp = pre.next;
                    pre.next = cur.next;
                    cur.next = cur.next.next;
                    pre.next.next = tmp;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
