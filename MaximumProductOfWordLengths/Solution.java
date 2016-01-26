import java.util.Arrays;

/**
 * Created by gzhou on 1/26/16.
 */
public class Solution {

    public static void main(String[] args) {
        String[] ss = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(ss));
    }

    public static int maxProduct(String[] words) {
        int ret = 0;
        int[] mask = new int[words.length];
        Arrays.fill(mask, 0);
        for (int i = 0; i < words.length; i++) {
            for (Character c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }

            for (int j =0; j < i; ++j) {
                if((mask[i] & mask[j])==0){
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }

}
