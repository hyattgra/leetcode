package WordPattern;

import java.util.*;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        int len = pattern.length();
        if (len != arr.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            String s = map.get(c);

            if (s == null) {
                if (map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            } else if (!s.equals(arr[i])) {
                return false;
            }
        }
        return true;
    }


}
