package LargestRectangleInHistogram;

import java.util.Stack;

/**
 * Created by Alan on 9/27/2015.
 */
public class Solution {

    public static void main(String[] args) {
        int[] test = {2, 1, 5, 6, 3};
        largestRectangleArea(test);
    }

    //    public static int largestRectangleArea(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//
//        int ret = 0;
//        int[] h = Arrays.copyOf(height, height.length + 1);
//
//        Stack<Integer> stack = new Stack<>();
//        int i = 0;
//        while (i < h.length) {
//            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
//                stack.push(i);
//                i++;
//            }else{
//                int index = stack.pop();
//                int width = stack.isEmpty()? i : i -stack.peek()-1;
//                ret = Math.max(ret, h[index] * width);
//            }
//        }
//        return ret;
//    }
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            int curHeight = i == height.length ? 0 : height[i];
            if (stack.isEmpty() || curHeight >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int localHeighestIndex = stack.pop();
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, len * height[localHeighestIndex]);
                i--;
            }
        }
        return max;
    }
}
