package RomantoInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan on 9/21/14.
 */
public class Solution {
    public static void main(String[] args) {


    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int index = s.length() - 1;
        int pre = 0;
        int value = 0;
        while (index >= 0) {
            int cur = map.get(s.charAt(index));
            if (cur >= pre) {
                value += cur;
            } else {
                value -= cur;
            }
            pre = cur;
            index--;
        }

        return value;

    }


}
