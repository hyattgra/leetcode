package GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alan on 1/3/2016.
 */
public class Solution {


    public List<String> generateAbbreviations(String word) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs(result, sb, word.toCharArray(), 0, 0);
        return result;
    }

    public void dfs(List<String> result, StringBuilder sb, char[] chars, int i, int num) {
        int len = sb.length();
        if (i == chars.length) {
            if (num != 0) {
                sb.append(num);
            }
            result.add(sb.toString());
        } else {
            dfs(result, sb, chars, i + 1, num + 1);

            if (num != 0) {
                sb.append(num);
            }

            dfs(result, sb.append(chars[i]), chars, i + 1, 0);
        }
        sb.setLength(len);
    }
}
