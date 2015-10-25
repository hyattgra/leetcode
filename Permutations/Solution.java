package Permutations;

//import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Alan on 11/17/14.
 */
public class Solution {

    public static void main(String[] args) {
//        Solution so = new Solution();
//        int[] arr = {1,2,3};
//        so.permute(arr);
    }

    public void permute(int[] num) {

        List<List<Integer>> re = new LinkedList<List<Integer>>();

        List<Integer> t = new LinkedList<Integer>();

        per(num, t, re);

        for(List<Integer> li : re){
            for(Integer l : li){
                System.out.println(l);
            }
            System.out.println("-------");
        }
    }


    public void per(int[] num, List<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == num.length){
            result.add(new LinkedList<Integer>(temp));
        }

        for(int in : num){
            if(temp.contains(in)){
                continue;
            }

            temp.add(in);
            per(num, temp, result);
            temp.remove(temp.size()-1);
        }

    }

}
