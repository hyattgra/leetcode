package ImplementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alan on 7/29/15.
 */
class MyStack {
    // Push element x onto stack.

    private Queue<Integer> enqueue = new LinkedList<>();
    private Queue<Integer> dequeue = new LinkedList<>();

    public void push(int x) {
        while (!enqueue.isEmpty()) {
            dequeue.offer(enqueue.poll());
        }
        enqueue.offer(x);
        while (!dequeue.isEmpty()) {
            enqueue.offer(dequeue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        enqueue.poll();
    }

    // Get the top element.
    public int top() {
        return enqueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return enqueue.isEmpty();
    }
}
