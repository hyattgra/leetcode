package FirstBadVersion;

/**
 * Created by Alan on 9/27/2015.
 */
public class Solution {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }

        return helper(1, n);
    }

    private int helper(int start, int end) {
        if (start >= end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return helper(start, mid);
        } else {
            return helper(mid + 1, end);
        }
    }

}
