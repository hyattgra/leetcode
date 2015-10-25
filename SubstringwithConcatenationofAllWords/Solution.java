package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 10/14/14.
 */
public class Solution {

    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        HashMap<String, Integer> lmap = new HashMap<String, Integer>();

        for(int i=0;i<L.length;i++){
            if(!lmap.containsKey(L[i])){
                lmap.put(L[i], 1);
            }
        }

        int len = L[0].length();
        int start = 0;
        int totallen = len * L.length;

        while(start + totallen <= S.length()){
            String Stemp = S.substring(start, start + totallen);
            String tempword = Stemp.substring(0, len);

            if(!lmap.containsKey(tempword)){
                start ++;
                continue;
            }

            ArrayList<String> show = new ArrayList<String>();
            for(int i=0;i + len <=totallen;i+=len){
                show.add(Stemp.substring(i, i + len));
            }

            for(int j=0;j<L.length;j++){
                if(show.contains(L[j])){
                    show.remove(L[j]);
                }else{
                    break;
                }
            }

            if(show.isEmpty()){
                result.add(start);
                start += len;
            }else{
                start ++;
            }

        }

        return result;

    }


}
