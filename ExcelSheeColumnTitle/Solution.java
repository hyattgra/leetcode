package ExcelSheeColumnTitle;

/**
 * Created by gzhou on 7/31/15.
 */
public class Solution {
    public String convertToTitle(int n) {
        String ret = "";
        while (n > 0) {
            ret = (char) ('A' + (n - 1) % 26) + ret;
            n = (n - 1) / 26;
        }//
        return ret;
    }
}
