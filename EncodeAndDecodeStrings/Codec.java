package EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 5/14/2016.
 */
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int stringSize = Integer.valueOf(s.substring(i, slash));
            String str = s.substring(slash + 1, slash + stringSize + 1);
            ret.add(str);
            i = slash + stringSize + 1;
        }
        return ret;
    }
}
