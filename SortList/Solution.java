package SortList;

/**
 * Created by gzhou on 7/22/15.
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);

    }


    // merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
//        if(l1==null){
//            return l2;
//        }
//        if(l2==null){
//            return l1;
//        }
//        if(l1.val<l2.val){
//            l1.next = merge(l1.next, l2);
//            return l1;
//        }else{
//            l2.next = merge(l1,l2.next);
//            return l2;
//        }

        // iterative version
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
