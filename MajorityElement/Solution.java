package MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzhou on 7/20/15.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        for(Integer i: nums){
            if(!map.containsKey(i+"")){
                map.put(i+"", 1);
            }else{
                map.put(i+"", map.get(i+"")+1);
            }
            if(map.get(i+"") >= nums.length/2 + 1){
                return i;
            }
        }
        return -1;
    }
}
