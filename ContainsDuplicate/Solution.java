package ContainsDuplicate;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
