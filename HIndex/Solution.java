package HIndex;

/**
 * Created by gzhou on 9/4/15.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int[] index = new int[citations.length + 1];
        for (int i : citations) {
            if (i <= citations.length) {
                index[i]++;
            } else {
                index[citations.length]++;
            }
        }
        int ret = 0;
        for (int i = citations.length; i >= 0; i--) {
            ret += index[i];
            if (ret >= i) {
                return i;
            }
        }
        return ret;
    }
}
