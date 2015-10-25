package TwoSumIIInputArrayIsSorted;

/**
 * Created by gzhou on 9/4/15.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while(true){
            if(numbers[start] + numbers[end] > target){
                end--;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else{
                ret[0] = start+1;
                ret[1] = end+1;
                break;
            }
            if(start >= end){
                return ret;
            }
        }
        return ret;
    }
}
