public class Solution {
    public int maximumGap(int[] nums) {
      if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        //used to calculate the position of a num in nums
        int bucketDiff = (int) Math.ceil((double)(max - min) / (nums.length - 1));

        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int i : nums) {
            if (i == min || i == max) {
                continue;
            }
            int index = (i - min) / bucketDiff;
            bucketMin[index] = Math.min(bucketMin[index], i);
            bucketMax[index] = Math.max(bucketMax[index], i);
        }

        //final loop to find the max gap
        int maxGap = Integer.MIN_VALUE;
        int previousMax = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] -previousMax);
            previousMax = bucketMax[i];
        }

        maxGap = Math.max(maxGap, max - previousMax);
        return maxGap;
    }
}
