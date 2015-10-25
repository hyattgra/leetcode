package PartitionList;

/**
 * Created by gzhou on 7/31/15.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1head = new ListNode(-1);
        ListNode l2head = new ListNode(-1);

        ListNode l1 = l1head;
        ListNode l2 = l2head;

        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else if (head.val >= x) {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }

        l1.next =l2head.next;
        l2.next = null;
        return l1head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
