package TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alan on 5/3/2016.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (Integer key : frequencyMap.keySet()) {
            Integer freq = frequencyMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }
        return ret;
    }
}
