package ImplementTrie;

import java.util.Map;

/**
 * Created by Alan on 7/23/15.
 */


public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if(cur.child[word.charAt(i)-'a'] == null){
                cur.child[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
                cur = cur.child[word.charAt(i)-'a'];
            }
            cur = cur.child[word.charAt(i)-'a'];
        }
        cur.isWord=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if(cur.child[word.charAt(i)-'a'] == null){
                return false;
            }
            cur = cur.child[word.charAt(i)-'a'];
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(cur.child[prefix.charAt(i)-'a'] == null){
                return false;
            }
            cur = cur.child[prefix.charAt(i)-'a'];
        }
        return true;

    }

    class TrieNode {
        // Initialize your data structure here.
        public char val;
        public boolean isWord;
        public TrieNode[] child = new TrieNode[26];

        public TrieNode() {

        }

        TrieNode(char c) {
            val = c;
        }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
