package AddBinary;

/**
 * Created by Alan on 7/18/15.
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int total = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0) + carry;
            sb.insert(0, total == 2 || total == 0 ? '0' : '1');
            carry = total > 1 ? 1 : 0;
        }

        return carry == 1 ? sb.insert(0, 1).toString() : sb.toString();
    }
}
