package ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by gzhou on 7/30/15.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" +");
        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);

    }
}
