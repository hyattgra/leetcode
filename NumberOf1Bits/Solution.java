package NumberOf1Bits;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        for(int i=0;i<32;i++){
            // watch the definition of '&'
            if((n & 1) == 1){
                ret++;
            }
            n = n>>1;
        }
        return ret;
    }
}
