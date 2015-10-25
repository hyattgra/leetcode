package LongestCommonPrefix;

/**
 * Created by Alan on 9/22/14.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();

    }

    public void test() {
        String s1 = "abc";
        String s2 = "abcd";
        String s3 = "abe";
        String s4 = "abcdef";
        String[] strs = {s1, s2, s3, s4};
        String[] s5 = {"a"};
        String ret = longestCommonPrefix(s5);
        System.out.print(ret);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }

        for (String s : strs) {
            if (s == "") {
                return "";
            }
        }

        if (strs.length == 0) {
            return "";
        }

        int j = 0;
        int i = 0;

        while (strs[i].length() - 1 > j && i < strs.length - 1) {

            if (strs[i].isEmpty()) {
                return "";
            }

            while (i < strs.length - 1 && strs[i].length() - 1 > j && strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                i++;
            }
            if (i == strs.length) {
                j++;
            } else {
                break;
            }
        }

        j = i < strs.length ? j - 1 : j;

        if(j==-1){
            return "";
        }

        String ret = strs[0] == "" ? "" : strs[0].substring(0, j + 1);

        return ret;

    }

}
