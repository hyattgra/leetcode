package ReorderList;


/***
 *
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // in-place reverse linkedlist
        ListNode pMiddle = p1;
        ListNode pCur = p1.next;
        while (pCur.next != null) {
            ListNode tnode = pCur.next;
            pCur.next = tnode.next;
            tnode.next = pMiddle.next;
            pMiddle.next = tnode;
        }

        p1 = head;
        p2 = pMiddle.next;

        while (p1 != pMiddle){
            pMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = pMiddle.next;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}