package ValidPalindrome;

/**
 * Created by Alan on 11/10/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        String ss;
        ss = s.toLowerCase();
        ss = ss.replaceAll("[^a-z^0-9]+","");
        for(int i=0;i<ss.length();i++){
            if(ss.charAt(i)!=ss.charAt(ss.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
