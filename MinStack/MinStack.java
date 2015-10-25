package MinStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by gzhou on 7/30/15.
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    ////
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        min = Math.min(min, x);
        stack.push(x);
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == min) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            min = Integer.MAX_VALUE;
            while (!stack2.isEmpty()) {
                int t = stack2.pop();
                min = Math.min(t, min);
                stack.push(t);

            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

