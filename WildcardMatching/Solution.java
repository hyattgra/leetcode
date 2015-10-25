package WildcardMatching;

/**
 * Created by gzhou on 6/5/15.
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int count = 0;
        for (int i = 0; i < plen; i++) {
            if (p.charAt(i) == '*') {
                count++;
            }
        }
        if (plen - count > slen) {
            return false;
        }
        boolean[][] dp = new boolean[plen + 1][slen + 1];

        dp[0][0] = true;
        for (int i = 0; i < plen; i++) {
            dp[i + 1][0] = p.charAt(i) == '*' ? dp[i][0] : false;
        }

        for (int i = 0; i < plen; i++) {
            for (int j = 0; j < slen; j++) {
                if(p.charAt(i) == '*'){
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                }else if(p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = false;
                }
            }
        }
        return dp[plen][slen];
    }


}
