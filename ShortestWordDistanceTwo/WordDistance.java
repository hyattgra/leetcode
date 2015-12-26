package ShortestWordDistanceTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 12/26/2015.
 */
public class WordDistance {

    HashMap<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);

            if (index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            }
            if (index1 > index2) {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }
}