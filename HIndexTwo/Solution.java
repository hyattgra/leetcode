package HIndexTwo;

/**
 * Created by Alan on 12/13/2015.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int len = citations.length;
        int ret = 0;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (citations[mid] >= len - mid) {
                ret = len - mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }
}
