package ValidParentheses;

import java.util.Stack;

/**
 * Created by Alan on 10/5/14.
 */
public class Solution {

    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.test();

    }

    public void test(){
        String s = "(){}";
        boolean r = isValid(s);

        System.out.println(r);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.push('#');

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            char chr = stack.peek();
            if(c == ')' && chr == '('){
                stack.pop();
            }else if(c==']' && chr=='['){
                stack.pop();
            }else if(c=='}' && chr=='{'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        if(stack.peek() == '#'){
            return true;
        }
        return false;
    }
}


