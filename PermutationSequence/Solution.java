package PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 6/21/15.
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(getPermutation(4, 9));

    }

    public static String getPermutation(int n, int k) {
        List<Character> ret = new ArrayList<>();

        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        List<Character> unused = new ArrayList<Character>();
        for (int i = 0; i < n; i++) {
            unused.add(String.valueOf(i + 1).charAt(0));
        }

        // TODO:
        //why j = k-1 ?
        for (int i = n; i >= 1; i--) {
            int j = (k - 1) / factorials[i - 1];
            k -= j * factorials[i - 1];
            ret.add(unused.get(j));
            unused.remove(j);
        }

        String word = new String();
        for (char c : ret) {
            word = word + c;
        }

        return word;
    }
}
