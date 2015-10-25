package StrobogrammaticNumber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alan on 9/8/15.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(isStrobogrammatic("1"));
    }
    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        char[] arr = num.toCharArray();
        List<Character> ret = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){
                return false;
            }else{
                ret.add(0, map.get(arr[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : ret){
            sb.append(c);
        }
        String res = sb.toString();
        return num.equals(res);
    }
}
