package com.payphone.leetcode;

/**
 * DFS || BFS
 */
public class N0559MaxDepth {

    public int maxDepth(Node root) {
        return helper(root, 0);
    }

    public int helper(Node root, int count) {
        if (root == null) return count;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, helper(child, count));
        }
        return max + 1;
    }
}
