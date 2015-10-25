package Subsets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alan on 12/12/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) {
            return (List) results;
        }

        Arrays.sort(S);
        ArrayList<Integer> init = new ArrayList<Integer>();
        results.add(init);

        for (int i = 0; i < S.length; i++) {
            insert(S[i], results);
        }
        return (List) results;
    }

    public void insert(int i, ArrayList<ArrayList<Integer>> tmp) {
        ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> tp : tmp) {
            ArrayList<Integer> newTp = new ArrayList<Integer>(tp);
            newTp.add(i);
            t.add(newTp);
        }

        tmp.addAll(t);
    }


}
