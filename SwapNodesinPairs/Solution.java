package SwapNodesinPairs;

public class Solution {

    public static void main(String[] args) {

    }

    public ListNode swapPairNode(ListNode head) {
        ListNode curr = head;
        ListNode temp = null;

        if (curr != null || curr.next != null) {
            temp = curr.next;
            curr.next = swapPairNode(temp.next);
            temp.next = curr;
        }

        return (temp != null) ? temp : curr;
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

