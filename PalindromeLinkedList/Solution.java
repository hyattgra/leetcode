package PalindromeLinkedList;

/**
 * Created by Alan on 9/7/15.
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.print(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode node = head;
        ListNode pre = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        len = len % 2 == 0 ? len / 2 : (len / 2) + 1;
        int i = len;
        while (i-- > 0 && pre.next != null) {
            pre = pre.next;
        }
        pre = reverse(pre);
        node = head;
        while (pre != null && node != null && len-- > 0) {
            if (pre.val != node.val) {
                return false;
            }
            pre = pre.next;
            node = node.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
