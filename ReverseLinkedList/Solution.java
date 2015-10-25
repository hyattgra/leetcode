package ReverseLinkedList;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode next = head.next;
//        ListNode newHead = reverseList(next);
//        next.next = head;
//        head.next = null;
//        return newHead;
        //iterative
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
