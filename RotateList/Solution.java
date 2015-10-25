package RotateList;

/**
 * Created by Alan on 6/29/15.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head;
        int pos = k % len;
        for (int i = 0; i < len - pos; i++) {
            cur = cur.next;
        }
        ListNode ret = cur.next;
        cur.next = null;

        return ret;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


