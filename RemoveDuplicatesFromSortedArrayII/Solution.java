package RemoveDuplicatesFromSortedArrayII;

/**
 * Created by Alan on 8/4/15.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        int index = 2;
        for (int i = index; i < nums.length; i++) {
            // watch "2"!
            if (nums[index - 2] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
