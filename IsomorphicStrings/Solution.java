package IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzhou on 8/21/15.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
