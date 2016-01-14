package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 1/14/2016.
 */
public class LRUCache {

    public class Node {
        Node pre;
        Node next;
        int val;
        int key;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    private void removeFirst() {
        removeNode(head.next);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToTail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        moveToTail(node);

        return node.val;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node.val = value;
            removeNode(node);
        }
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            removeFirst();
        }
    }


}
