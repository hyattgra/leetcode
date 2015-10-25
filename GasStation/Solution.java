package GasStation;

/**
 * Created by Alan on 8/1/15.
 */
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tmpSum = 0;
        int totalSum = 0;
        for (int i = 0; i < cost.length; i++) {
            tmpSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (tmpSum < 0) {
                start = i + 1;
                tmpSum = 0;
            }
        }
        if(totalSum >= 0){
            return start;
        }
        return -1;
    }
}
