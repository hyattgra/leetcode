package BestMeetingPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alan on 12/27/2015.
 */
public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> iList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    iList.add(i);
                    jList.add(j);
                }
            }
        }

        return getDist(iList) + getDist(jList);
    }

    private int getDist(List<Integer> list) {
        int ret = 0;

        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            ret += list.get(j--) - list.get(i++);
        }
        return ret;
    }
}
