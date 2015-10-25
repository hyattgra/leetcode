package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 9/29/14.
 */
public class Solution {
    public static void main(String[] args) {
//
//        Solution s = new Solution();
//        s.test();

    }

    public void test() {
        String s = "2333454";
        List<String> res = letterCombinations(s);
        for (String ss : res) {
            System.out.println(ss);
        }
        System.out.println(res.size());

    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            res.add("");
        } else {
            List<String> pre = letterCombinations(digits.substring(1));
            char c = digits.charAt(0);
            for (String s : pre) {
                if (c == '2') {
                    res.add("a" + s);
                    res.add("b" + s);
                    res.add("c" + s);
                } else if (c == '3') {
                    res.add("d" + s);
                    res.add("e" + s);
                    res.add("f" + s);
                } else if (c == '4') {
                    res.add("h" + s);
                    res.add("g" + s);
                    res.add("i" + s);
                } else if (c == '5') {
                    res.add("j" + s);
                    res.add("k" + s);
                    res.add("l" + s);
                } else if (c == '6') {
                    res.add("m" + s);
                    res.add("n" + s);
                    res.add("o" + s);
                } else if (c == '7') {
                    res.add("p" + s);
                    res.add("g" + s);
                    res.add("s" + s);
                } else if (c == '8') {
                    res.add("t" + s);
                    res.add("u" + s);
                    res.add("v" + s);
                } else if (c == '9') {
                    res.add("w" + s);
                    res.add("x" + s);
                    res.add("y" + s);
                    res.add("z" + s);
                }
            }
        }


        return res;
    }


}
