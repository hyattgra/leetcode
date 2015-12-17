package MaximalRectangle;

import java.util.Stack;

/**
 * Created by Alan on 9/27/2015.
 */
public class Solution {   

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] row = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                row[i] = 1;
            }
        }
        max = largestRectangleArea(row);
        for (int i = 1; i < matrix.length; i++) {
            row = update(row, matrix, i);
            max = Math.max(max, largestRectangleArea(row));
        }

        return max;

    }

    private int[] update(int[] row, char[][] matrix, int curRow) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[curRow][i] == '1') {
                row[i]++;
            } else {
                row[i] = 0;
            }
        }
        return row;
    }

    private int largestRectangleArea(int[] height) {
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
                int localHighestIndex = stack.pop();
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, len * height[localHighestIndex]);
                i--;
            }
        }
        return max;
    }
}
