package com.payphone.ds.tire;

import java.util.HashMap;

/**
 * leetcode 211
 */
public class WordDictionary {

    private class Node {
        boolean isWord = false;
        // 仅字母，且不考虑大小写
        // Node[] n = new Node[26];
        // 到下一个节点的映射,任意字符
        HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return matcher(root, word, 0);
    }

    private boolean matcher(Node node, String word, int index) {
        if (index == word.length()) return node.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) return false;
            return matcher(node.next.get(c), word, index + 1);
        } else {
            // 所有的可能都尝试匹配一次。
            for (char tmp : node.next.keySet()) {
                if (matcher(node.next.get(tmp), word, index + 1)) return true;
            }
            return false;
        }
    }
}
