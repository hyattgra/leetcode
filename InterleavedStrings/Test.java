package InterleavedStrings;

import java.util.Arrays;

/**
 * Created by Alan on 9/8/14.
 */
public class Test {

    public static void main(String[] args) {
//        String[] s1 = {"ew","qw","io"};
//        String[] s2 = {"fg","kj","pl"};
//        Test t = new Test();
//        System.out.print(t.combine(s1,s2));
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";
        Test t = new Test();

        System.out.print(t.isInterleaved(s1, s2, s3));

    }

//    public String combine(String[] s1, String[] s2) {
//        String[] result = new String[s1.length + s2.length];
//        for (int i = 0; i < s1.length; i++) {
//            result[2 * i] = s1[i];
//            result[2 * i + 1] = s2[i];
//        }
//
//        String S = "";
//        for (String s : result)
//            S += s;
//        return S;
//    }
//
//    public String[] slice(int n, String s) {
//        char[] chars = s.toCharArray();
//        int len = chars.length % n == 0 ? chars.length / n : chars.length / n + 1;
//
//        for (int i = 0; i < chars.length; i += 1) {
//
//        }
//
//    }

    public boolean isInterleaved(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
        match[0][0] = true;

        for (int i = 1; i < s1.length() + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && match[i - 1][0]) {
                match[i][0] = true;
            }
        }

        for (int j = 1; j < s2.length() + 1; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && match[0][j - 1]) {
                match[0][j] = true;
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                char c = s3.charAt(i + j - 1);
                if (s2.charAt(j - 1) == c && match[i][j - 1]) {
                    match[i][j] = true;
                }
                if (s1.charAt(i - 1) == c && match[i - 1][j]) {
                    match[i][j] = true;
                }
            }
        }

        return match[s1.length()][s2.length()];


    }

}
