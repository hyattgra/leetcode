package MergeTwoSortedLists;

/**
 * Created by Alan on 6/13/15.
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l7 = new ListNode(7);
        ListNode l10 = new ListNode(10);
        ListNode l15 = new ListNode(15);
        ListNode l2 = new ListNode(2);
        ListNode l9 = new ListNode(9);
        ListNode l11 = new ListNode(11);
        ListNode l12 = new ListNode(12);

        l1.next = l7;
        l7.next = l10;
        l10.next = l15;

        l2.next = l9;
        l9.next = l11;
        l11.next = l12;
        System.out.print(mergeTwoLists(l1, l2).val);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
