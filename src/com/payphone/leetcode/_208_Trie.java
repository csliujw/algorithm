package com.payphone.leetcode;

public class _208_Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True


        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}

/**
 * Trie树的存储
 * 按单词的顺序，把每个字母当一条边，树里的每天路径就是一个单词。
 */
class Trie {
    private Node root = null;

    /*
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     * 把 a-z 映射成0-25
     */
    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            // p.son[u] = new Node() 就表示 word.charAt(i) 存入了Trie
            if (p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return p.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * 如果没有打标记，就是前缀。只要能搜到路径，就返回true。
     */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return true;
    }
}

class Node {
    // 我们走Trie的时候，我们要走a，那么我们直接走的son['a'-'0']
    // 我们规定 son 是按顺序存的 a b c d e
    // 如果我们想知道 这个边是否存在，看son有没有就行。
    Node[] son = new Node[26];

    // 当前节点是某个单词的节点
    boolean isEnd = false;

    public Node() {
        for (int i = 0; i < son.length; i++) {
            son[i] = null;
        }
    }
}