package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 12/11/14.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();

        if (s == null || s.length() == 0)
            return (List) result;

        cal(result, list, s);
        return (List) result;
    }


    public boolean isPalindrome(String s) {
        int j = s.length() - 1;
        int i = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    public void cal(ArrayList<ArrayList<String>> result, ArrayList<String> list, String str) {
        if (str.length() == 0) {
            result.add(new ArrayList<String>(list));
        }

        for (int i = 1; i <= str.length(); i++) {
            String sub = str.substring(0, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                String remain = str.substring(i);
                cal(result, list, remain);
                list.remove(list.size() - 1);
            }
        }


    }
}
