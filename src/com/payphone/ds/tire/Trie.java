package com.payphone.ds.tire;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie只用于char Character
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public void add(String word) {
        Node cur = new Node();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        // 以前这个不是单词的话
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean container(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        // 一个单词也是这个单词的前缀
        return true;
    }

    public int getSize() {
        return size;
    }

    private class Node {
        boolean isWord = false;
        // 仅字母，且不考虑大小写
        Node[] n = new Node[26];
        // 到下一个节点的映射,任意字符
        Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }
}
