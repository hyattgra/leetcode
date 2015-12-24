package AddAndSearchWord;

import java.util.HashMap;

/**
 * Created by Alan on 12/23/2015.
 */
public class WordDictionary {

    public Node root;

    public WordDictionary() {
        this.root = new Node();
        root.val = ' ';
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.childMap.get(c) == null) {
                cur.childMap.put(c, new Node(c));
            }
            cur = cur.childMap.get(c);
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Node cur = root;
        return dfs(word, cur);

    }


    private boolean dfs(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node nde : node.childMap.values()) {
                    if (dfs(word.substring(i + 1), nde)) {
                        return true;
                    }
                }
                return false;
            }
            if (!node.childMap.containsKey(c)) {
                return false;
            } else {
                node = node.childMap.get(c);
            }
        }
        return node.isWord;
    }

    public class Node {
        boolean isWord;
        char val;
        HashMap<Character, Node> childMap = new HashMap<>();

        public Node() {

        }

        public Node(char c) {
            this.val = c;
        }
    }
}
