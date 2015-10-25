package GrayCode;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 7/21/15.
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> res = grayCode(11);
        for(int i: res){
            System.out.println(i);
        }

    }

    public static List<Integer> grayCode(int n) {
        String[] res = gray(n);
        List<Integer> ret = new ArrayList<>();
        for (String s : res) {
            int decimal = Integer.parseInt(s, 2);
            ret.add(decimal);
        }
        return ret;
    }

    private static String[] gray(int n) {
        String[] grayCodes = new String[(int) Math.pow(2, n)];

        if (n == 1) {
            grayCodes[0] = "0";
            grayCodes[1] = "1";
            return grayCodes;
        } else if (n == 0) {
            grayCodes[0] = "0";
            return grayCodes;
        }
        String[] res = gray(n - 1);
        for (int i = 0; i < res.length; i++) {
            grayCodes[i] = "0" + res[i];
            grayCodes[grayCodes.length - 1 - i] = "1" + res[i];
        }
        return grayCodes;
    }
}
/**
 * Created by gzhou on 7/22/15.
 */
//public class Solution {
//    public List<Integer> grayCode(int n) {
//        List<Integer> ret = new ArrayList<>();
//        if (n == 0) {
//            ret.add(0);
//            return ret;
//        }
//        ret = grayCode(n - 1);
//        for (int i = ret.size()-1; i >=0; i--) {
//            ret.add((1 << (n - 1)) + ret.get(i));
//        }
//        return ret;
//
//    }
//}
