package AddTwoNumbers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alan on 9/16/14.
 */
public class Test {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }

    public void test() {
//        ListNode lA = new ListNode(2);
//        ListNode lB = new ListNode(4);
//        ListNode lC = new ListNode(3);
//
//        ListNode lD = new ListNode(5);
//        ListNode lE = new ListNode(6);
//        ListNode lF = new ListNode(4);
//
//        lA.next = lB;
//        lB.next = lC;
//
//        lD.next = lE;
//        lE.next = lF;

        ListNode lA = new ListNode(5);
        ListNode lB = new ListNode(5);

        ListNode r = addTwoNumbers(lA, lB);

//        System.out.print(r.val);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*ListNode c1 = l1;
        ListNode c2 = l2;
        int sumAdd = 0;
        int d = 0;
        ListNode result = new ListNode(d);
        ListNode ret = result;

        while (c1 != null || c2 != null) {

            sumAdd = sumAdd / 10;

            if (c1 != null) {
                sumAdd += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sumAdd += c2.val;
                c2 = c2.next;
            }

            d = sumAdd % 10;
            ListNode temp = new ListNode(d);
            result.next = temp;
            result = result.next;

        }

        if(sumAdd / 10 !=0){
            result.next = new ListNode(sumAdd / 10);
        }

        return ret.next;*/
        ListNode c1 = l1;
        ListNode c2 = l2;
        int sum = 0;
        ListNode sumNode = new ListNode(0);
        ListNode ret = sumNode;

        while (c1 != null || c2 != null) {
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            int remain = sum % 10;
            sum = sum / 10;

            ListNode tem = new ListNode(remain);
            sumNode.next = tem;
            sumNode = sumNode.next;
        }

        if (sum / 10 != 0) {
            sumNode.next = new ListNode(sum / 10);
        }
        return ret.next;
    }

}


