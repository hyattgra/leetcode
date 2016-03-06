package WordLadderII;

import java.util.*;

/**
 * Created by Alan on 3/6/2016.
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> allNeighbors = new HashMap<>();
        bfs(beginWord, endWord, wordList, distance, allNeighbors);
        List<List<String>> ret = new ArrayList<List<String>>();
        dfs(beginWord, endWord, distance, allNeighbors,
                new ArrayList<String>(), ret);

        return ret;
    }


    private void bfs(String beginWord, String endWord, Set<String> wordList,
                     Map<String, Integer> distance, Map<String, List<String>> allNeighbors) {
        for (String str : wordList) {
            allNeighbors.put(str, new ArrayList<String>());
        }

        Queue<String> nextString = new LinkedList<>();
        distance.put(beginWord, 0);
        nextString.add(beginWord);

        while (!nextString.isEmpty()) {
            String cur = nextString.poll();
            List<String> neighbors = generateNeighbors(cur, wordList);
            for (String neighbor : neighbors) {
                allNeighbors.get(cur).add(neighbor);
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(cur) + 1);
                    if (!neighbor.equals(endWord)) {
                        nextString.add(neighbor);
                    }
                }
            }
        }
    }

    private void dfs(String beginWord, String endWord,
                     Map<String, Integer> distance, Map<String, List<String>> allNeighbors,
                     List<String> temp, List<List<String>> ret) {
        temp.add(beginWord);
        if (beginWord.equals(endWord)) {
            ret.add(new ArrayList<String>(temp));
        } else {
            List<String> neighbors = allNeighbors.get(beginWord);
            for (String str : neighbors) {
                if (distance.get(str) == distance.get(beginWord) + 1) {
                    dfs(str, endWord, distance, allNeighbors, temp, ret);
                }
            }
        }

        temp.remove(temp.size() - 1);
    }

    private List<String> generateNeighbors(String str, Set<String> wordList) {
        List<String> ret = new ArrayList<>();
        char[] cur = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (char c = 'a'; c < 'z'; c++) {
                if (c == cur[i]) {
                    continue;
                }
                char oldChar = cur[i];
                cur[i] = c;
                String newWord = new String(cur);
                if (wordList.contains(newWord)) {
                    ret.add(newWord);
                }
                cur[i] = oldChar;
            }
        }
        return ret;
    }
}
