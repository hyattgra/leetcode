package LongestValidParentheses;

import java.util.Stack;

/**
 * Created by Alan on 10/14/14.
 */
public class Solution {
    public static void main(String[] args) {

        String s = ")()";
        System.out.println(longestValidParentheses(s));

    }

    public static int longestValidParentheses(String s) {
        if(s.length()<2 || s == null){
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[s.length() - 1] = 0;
        int max = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + 1 + dp[i + 1];
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                }
                if (j < s.length() - 1) {
                    dp[i] += dp[j + 1];
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;


    }
}
