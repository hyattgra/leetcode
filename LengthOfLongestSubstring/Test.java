package LengthOfLongestSubstring;

/**
 * Created by Alan on 9/14/14.
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        System.out.print(t.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        boolean[] map = new boolean[256];
        int i =0;
        int j;

        for(j=0;j<s.length();j++){
            if(map[s.charAt(j)]){
                max = Math.max(max, j-i);
                while(s.charAt(i)!=s.charAt(j)){
                    map[s.charAt(i)] = false;
                    i++;
                }
                i++;
            }else{
                map[s.charAt(j)] = true;
            }
        }

        return Math.max(max, j-i);

    }



}
