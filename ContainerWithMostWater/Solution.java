package ContainerWithMostWater;

/**
 * Created by Alan on 9/21/14.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.test();

    }

    public void test() {
        int[] height = {2, 3, 4, 2, 2, 7, 8, 9, 1, 8};
        int ret = maxArea(height);
        System.out.print(ret);

    }

    public int maxArea(int[] height) {
        int max = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high) {
            max = Math.max(max, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }


        return max;

    }
}
