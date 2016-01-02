package RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alan on 1/2/2016.
 */
public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add(s);

        //find minimum so ret.isEmpty()
        while (ret.isEmpty()) {
            Set<String> tmpSet = new HashSet<>();
            for (String str : set) {
                if (isValid(str)) {
                    ret.add(str);
                    continue;
                }

                tmpSet.addAll(removeOne(str));
            }
            set = tmpSet;
        }

        return ret;
    }

    private boolean isValid(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }
            if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

    private Set<String> removeOne(String s) {
        Set<String> ret = new HashSet<>();

        if (s.length() == 1) {
            ret.add("");
            return ret;
        }

        for (int i = 0; i < s.length(); i++) {
            ret.add(s.substring(0, i) + s.substring(i + 1));
        }

        return ret;
    }


}
