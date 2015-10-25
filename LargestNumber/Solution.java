package LargestNumber;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Alan on 1/16/15.
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.print(largestNumber(arr));

    }

    public static String largestNumber(int[] num) {

        String[] ss = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(ss, (String x, String y) -> (y + x).compareTo(x + y));
        return Arrays.stream(ss).reduce((x, y) -> x.equals("0") ? y : x + y).get();

    }


}
