package ShortestWordDistance;

/**
 * Created by Alan on 9/3/15.
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ret = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    ret = Math.min(ret, i - index2);
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    ret = Math.min(ret, i - index1);
                }
            }
        }
        return ret;
    }
}
