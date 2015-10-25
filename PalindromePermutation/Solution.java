package PalindromePermutation;

/**
 * Created by Alan on 8/31/15.
 */
public class Solution {


    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[255];
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i]] == 0) {
                arr[chars[i]] = 1;
            } else {
                arr[chars[i]]--;
            }
        }
        int count = 0;
        for (Integer i : arr) {
            if (i != 0) {
                count++;
            }
        }
        return count == 1 || count == 0;
    }
}
