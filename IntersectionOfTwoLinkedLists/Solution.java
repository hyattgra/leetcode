package IntersectionOfTwoLinkedLists;

/**
 * Created by Alan on 7/23/15.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        int lenA = count(headA);
        int lenB = count(headB);
        int diff = Math.abs(lenA - lenB);

        ListNode curA = headA;
        ListNode curB = headB;
        while(diff!=0){
            if(lenA<lenB){
                curB = curB.next;
            }else{
                curA = curA.next;
            }
        }
        while (curA != curB && curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;

    }

    private int count(ListNode ln) {
        int i = 0;
        while (ln != null) {
            i++;
            ln = ln.next;
        }
        return i;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
