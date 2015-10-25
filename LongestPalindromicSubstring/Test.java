package LongestPalindromicSubstring;

/**
 * Created by Alan on 9/19/14.
 */
public class Test {


    public static void main(String[] args) {
        Test t = new Test();
        t.test();

    }

    public void test() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        String s = "abcdxyxw13";

        String ret = longestPalindrome(s);
        System.out.print(ret);
    }

    public String longestPalindrome(String s) {
        char[] arr = transform(s).toCharArray();
        int[] P = new int[arr.length + 1];
        int id = 0;
        int mx = 0;
        for (int i = 1; i < arr.length-1; i++) {
            P[i] = mx > i ? Math.min(P[2*id -i], mx-i) : 0;
            while(arr[i+P[i] +1] == arr[i-1-P[i]]){
                P[i]++;
            }
            if(i + P[i] > mx){
                mx = i + P[i];
                id = i;
            }
        }

        int center =0;
        int maxlen = 0;
        for(int i=1;i<P.length-1;i++){
            if(P[i]>maxlen){
                maxlen = P[i];
                center = i;
            }
        }

        return s.substring((center - maxlen -1)/2, (center - maxlen -1)/2 + maxlen);

    }

    public String transform(String S) {
        int len = S.length();
        if (len == 0) {
            return "@$";
        }
        String s = "@";
        for (int i = 0; i < len; i++) {
            s += "#" + S.charAt(i);
        }
        s += "#$";

        return s;
    }


}
