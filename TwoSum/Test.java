package TwoSum;

import java.util.HashMap;

/**
 * Created by Alan on 9/8/14.
 */
public class Test {

    public static void main(String[] args) {

        int[] numbers = {7, 2, 11, 15};
        Test t = new Test();
        int[] result = t.twoSum(numbers, 13);
        for (int n : result) {
            System.out.print(n + " ");
        }

    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                res[1] = i+1;
                res[0] = map.get(target-numbers[i]);
            }else{
                map.put(numbers[i], i+1);
            }
        }
        return res;
    }

}
