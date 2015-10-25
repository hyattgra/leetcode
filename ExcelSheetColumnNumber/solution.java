//package ExcelSheetColumnNumber;
//
///**
// * Created by gzhou on 7/20/15.
// */
//public class Solution {
//    public static void main(String[] args) {
//        System.out.print(titleToNumber("AA"));
//    }
//
//    public static int titleToNumber(String n) {
//        int ret = 0;
//        char[] chars = n.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int it = chars[i] - 'A' + 1;
//            ret = ret * 26 + it;
//        }
//        return ret;
//    }
//}
