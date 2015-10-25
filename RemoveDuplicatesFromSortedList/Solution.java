package RemoveDuplicatesFromSortedList;

/**
 * Created by Alan on 7/21/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode cur = head;
//        while (cur.next != null && cur.next.val == head.val) {
//            cur = cur.next;
//        }
//        head.next = deleteDuplicates(cur.next);
//        return head;

        // iterative run
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur!=null){
            if(cur.next==null){
                break;
            }
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
