package LinkedListCycleTwo;

/**
 * Created by Alan on 8/1/15.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode ln = head;
        // check fast.next first
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(ln != slow){
                    ln = ln.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
