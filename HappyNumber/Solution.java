package HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gzhou on 7/20/15.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.print(isHappy(2));
    }
    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        if(check(n, set)==-1){
            return true;
        }else if(check(n, set)==-2){
            return false;
        }
        return false;

    }

    private static int check(int n, Set<Integer> set){
        if(n == 1){
            return -1;
        }
        if(!set.contains(n)){
            set.add(n);
        }else{
            return -2;
        }
        char[] arr = String.valueOf(n).toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += Math.pow(Integer.parseInt(arr[i]+""), 2);
        }
        return check(res, set);
    }
}
