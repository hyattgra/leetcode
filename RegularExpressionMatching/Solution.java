package RegularExpressionMatching;

/**
 * Created by Alan on 9/21/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public void test() {

    }

    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            if(s.isEmpty()){
                return true;
            }
            return false;
        }

        if(p.length()==1){
            return (s.length()==1) && (p.charAt(0) == s.charAt(0)) || p.charAt(0)=='.';
        }

        if(p.charAt(1)!='*'){
            if(s.isEmpty()){
                return false;
            }else {
                return (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.')
                && isMatch(s.substring(1), p.substring(1));
            }
        }

        while(s.length()>0  && (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.')){
            if(isMatch(s, p.substring(2))){
                return true;
            }
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));

    }


}
