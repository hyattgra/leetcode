package Anagrams;

import java.util.*;

/**
 * Created by gzhou on 6/10/15.
 */
public class Solution {

    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)){
                List<String> t = new ArrayList<String>();
                t.add(strs[i]);
                map.put(key, t);
            }else{
                map.get(key).add(strs[i]);
            }
        }
        List<String> ret = new ArrayList<String>();
        for(Map.Entry<String, List<String>> entry :  map.entrySet()){
            if(entry.getValue().size() > 1){
                ret.addAll(entry.getValue());
            }
        }
        return ret;
    }
}
