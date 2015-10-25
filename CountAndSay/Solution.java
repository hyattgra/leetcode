package CountAndSay;

/**
 * Created by Alan on 3/8/15.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.print(countAndSay(4));
    }

    public static String countAndSay(int n) {

        if (n <= 0) {
            return null;
        }

        String S = "1";
        int cnt = 1;
        while (cnt < n) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < S.length(); j++) {
                if (S.charAt(j) == S.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(S.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(String.valueOf(count));
            sb.append(S.charAt(S.length()-1));
            S = sb.toString();
            cnt ++;
        }
        return S;
    }
}
