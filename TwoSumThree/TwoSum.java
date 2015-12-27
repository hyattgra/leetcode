package TwoSumThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 12/27/2015.
 */
public class TwoSum {

    private List<Integer> list;
    private HashMap<Integer, Integer> map;


    public TwoSum() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        list.add(number);
        if (!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Integer num1 : list) {
            int num2 = value - num1;
            if ((num2 != num1 && map.containsKey(num2)) || (num2 == num1 && map.get(num1) > 1)) {
                return true;
            }
        }
        return false;
    }
}