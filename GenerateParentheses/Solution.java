package GenerateParentheses;

import javax.xml.ws.handler.HandlerResolver;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Alan on 10/5/14.
 */
public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        s.test();

    }

    public void test() {
        int n = 4;
        List<String> rs = generateParenthesis(n);
        for(String s : rs){
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs("", n, n, result);
        return result;
    }

    public void dfs(String temp, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(temp);
            return;
        }
        if (left > 0) {
            dfs(temp + "(", left - 1, right, result);
        }
        if (right > left) {
            dfs(temp + ")", left, right - 1, result);
        }
    }


}
