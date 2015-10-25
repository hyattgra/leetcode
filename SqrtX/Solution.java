package SqrtX;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    public int mySqrt(int x) {
//        int ret = 0;
//        while (ret * ret <= x) {
//            ret ++;
//        }
//        return ret;
        //newton method
        double x0 = 1;
        while (Math.abs(Math.pow(x0, 2) - x) >= 1) {
            x0 = (x0 + x / x0) / 2;
        }
        return (int)x0;
    }
}
