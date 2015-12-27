package PaintHouse;

/**
 * Created by Alan on 12/27/2015.
 */
public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int lastR = 0;
        int lastB = 0;
        int lastG = 0;
        for (int i = 0; i < costs.length; i++) {
            int curR = lastR;
            int curB = lastB;
            int curG = lastG;
            lastR = Math.min(curB, curG) + costs[i][0];
            lastB = Math.min(curR, curG) + costs[i][1];
            lastG = Math.min(curR, curB) + costs[i][2];
        }

        return Math.min(Math.min(lastR, lastG), lastB);
    }
}
