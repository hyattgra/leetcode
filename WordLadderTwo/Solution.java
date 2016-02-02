package WordLadderTwo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Alan on 2/2/2016.
 */
public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }

        Queue<String> words = new LinkedList<String>();
        Queue<Integer> distance = new LinkedList<Integer>();

        words.offer(beginWord);
        distance.offer(1);

        while (!words.isEmpty()) {
            String curWord = words.poll();
            Integer d = distance.poll();

            if (curWord.equals(endWord)) {
                return d;
            }

            for (int i = 0; i < curWord.length(); i++) {
                char[] curarr = curWord.toCharArray();
                for (char c = 'a'; c < 'z'; c++) {
                    curarr[i] = c;
                    String newWord = new String(curarr);
                    if (wordList.contains(newWord)) {
                        words.offer(newWord);
                        distance.offer(d + 1);
                        wordList.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
