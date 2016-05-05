package NestedListWeightSum;

import java.util.List;

/**
 * Created by Alan on 5/4/2016.
 */
public class Soltion {
    int sum = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        depthSum(nestedList, 1);
        return sum;
    }

    private void depthSum(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null) {
            return;
        }
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger()) {
                depthSum(nestedInteger.getList(), depth + 1);
            } else {
                sum += depth * nestedInteger.getInteger();
            }
        }
    }


    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
