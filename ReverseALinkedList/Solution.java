package ReverseALinkedList;

/**
 * Created by Alan on 10/9/14.
 */
public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        s.test();

    }

    public void test(){
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode re = reverse(l0);
        while(re!=null){
            System.out.println(re.val);
            re = re.next;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head.next;
        ListNode last = head;

        while(cur!=null){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }

        head = dummy.next;

        return head;
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
