//package RemoveNthNodeFromEndofList;
//
///**
// * Created by Alan on 9/29/14.
// */
//
//import AddTwoNumbers.Test;
//
///**
// * Definition for singly-linked list.
// */
//
//public class Solution {
//    public static void main(String[] args) {
//
//        Solution s = new Solution();
//        s.test();
//
//    }
//
//
//    public void test() {
//        ListNode n = new ListNode(1);
//
//        ListNode re = removeNthFromEnd(n, 1);
//
//        while (n != null) {
//            System.out.println(re.val);
//            re = re.next;
//        }
//    }
//
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) {
//            return null;
//        }
//
//        ListNode sentinal = new ListNode(0);
//        sentinal.next = head;
//
//        ListNode fast = new ListNode(0);
//        fast.next = head;
//        ListNode slow = new ListNode(0);
//        slow.next = head;
//
//        while (n > 0 && fast != null) {
//            fast = fast.next;
//            n--;
//        }
//
//        while (fast != null && fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//
//        slow.next = slow.next.next;
//
//        if (sentinal.next == slow) {
//            return sentinal.next;
//        }
//
//        if () {
//
//        }
//
//    }
//
//
//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
//
//}
