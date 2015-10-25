package PascalsTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 8/20/15.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ret = new Integer[rowIndex + 1];
        Arrays.fill(ret, 0);
        ret[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            ret[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                ret[j] = ret[j] + ret[j - 1];
            }
        }
        return Arrays.asList(ret);
    }

}
