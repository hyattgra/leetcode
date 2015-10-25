package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 7/26/15.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        List<Integer> tmp = new ArrayList<Integer>();
        dfs(s, ret, tmp, 0, 4);
        return ret;
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() == 3 && Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    private void dfs(String s, List<String> ret, List<Integer> tmp, int start, int remain) {
        if (remain == 1) {
            String tmpStr = s.substring(start, s.length());
            if (!isValid(tmpStr)) {
                return;
            }
            int tmpInt = Integer.parseInt(tmpStr);
            String str = "";
            for (int i : tmp) {
                str += i + ".";
            }
            str += tmpInt;
            ret.add(str);
        } else {
            for (int i = 0; i < 4; i++) {
                int end = start + i;
                if (end >= s.length()) {
                    break;
                }
                String tmpStr = s.substring(start, end);
                if (!isValid(tmpStr)) {
                    continue;
                }
                tmp.add(Integer.parseInt(tmpStr));
                dfs(s, ret, tmp, end, remain - 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
