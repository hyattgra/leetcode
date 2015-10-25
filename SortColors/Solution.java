package SortColors;

/**
 * Created by Alan on 7/19/15.
 */
public class Solution {
    public void sortColors(int[] nums) {
//        int countRed = 0;
//        int countWhite = 0;
//        int countBlue = 0;
//        for (int i : nums) {
//            if (i == 0) {
//                countRed++;
//            } else if (i == 1) {
//                countWhite++;
//            } else if (i == 2) {
//                countBlue++;
//            }
//        }
//        int i = 0;
//        for (; i < countRed; i++) {
//            nums[i] = 0;
//        }
//        for (; i < countRed + countWhite; i++) {
//            nums[i] = 1;
//        }
//        for (; i < countRed + countWhite + countBlue; i++) {
//            nums[i] = 2;
//        }

        // one-pass
        if (nums == null || nums.length == 0) {
            return;
        }
        int redPtr = 0;
        int bluePtr = nums.length - 1;
        while (redPtr < nums.length && nums[redPtr] == 0) {
            redPtr++;
        }
        while (bluePtr >= 0 && nums[bluePtr] == 2) {
            bluePtr--;
        }
        int cur = redPtr;
        while (cur <= bluePtr) {
            if (nums[cur] == 0) {
                swap(nums, redPtr, cur);
                // cur move forward, since all the element before cur is red.
                cur++;
                redPtr++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, bluePtr);
                // cur does not need to move forward, since dnt know what the color is on current cur.
                bluePtr--;
            } else {
                cur++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
