package FindPeakElement;

/**
 * Created by gzhou on 7/20/15.
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // binary search
        while(left<=right){
            if(left==right){
                return left;
            }
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return -1;
    }
}
