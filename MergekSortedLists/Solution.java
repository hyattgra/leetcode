package MergekSortedLists;

import java.util.List;

/**
 * Created by Alan on 10/7/14.
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        } else if (lists.size() == 1) {
            return lists.get(0);
        }

        int mid = (lists.size() - 1) / 2;

        ListNode l1 = mergeKLists(lists.subList(0, mid + 1));
        ListNode l2 = mergeKLists(lists.subList(mid + 1, lists.size()));

        ListNode mergedNode = merge(l1, l2);

        return mergedNode;
    }

    public ListNode merge(ListNode n, ListNode m) {
        ListNode dumyhead = new ListNode(0);
        ListNode list = dumyhead;

        while (n != null && m != null) {
            if (n.val < m.val) {
                list.next = n;
                n = n.next;
            } else {
                list.next = m;
                m = m.next;
            }
            list = list.next;
        }

        while (n != null) {
            list.next = n;
            n = n.next;
            list = list.next;
        }

        while (m != null) {
            list.next = m;
            m = m.next;
            list = list.next;
        }

        return dumyhead.next;
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


