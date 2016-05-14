package ReverseVowelsOfAString;

/**
 * Created by Alan on 5/14/2016.
 */
public class Solution {
    public String reverseVowels(String s) {
        String KEY = "AEIOUaeiou";
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (KEY.indexOf(s.charAt(i)) != -1) {
                while (KEY.indexOf(s.charAt(j)) == -1) {
                    j--;
                }
                sb.append(s.charAt(j));
                j--;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
