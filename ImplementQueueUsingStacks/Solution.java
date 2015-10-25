package ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {

    class MyQueue {
        // Push element x to the back of queue.
        Stack<Integer> enque = new Stack<>();
        Stack<Integer> deque = new Stack<>();
        public void push(int x) {
            while(!deque.isEmpty()){
                enque.push(deque.pop());
            }
            enque.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            while(!enque.isEmpty()){
                deque.push(enque.pop());
            }
            deque.pop();
        }

        // Get the front element.
        public int peek() {
            while(!enque.isEmpty()){
                deque.push(enque.pop());
            }
            return deque.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return deque.isEmpty() && enque.isEmpty();
        }
    }
}
