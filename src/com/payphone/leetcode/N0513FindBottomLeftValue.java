package com.payphone.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class N0513FindBottomLeftValue {
    // BFS 广度优先
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            // 先 right 在 left，这样left 一定会出现在 queue 的最后一个
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    int maxLevel = -1;
    int ans = -1;

    // DFS 深度优先
    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    public void helper(TreeNode root, int curLevel) {
        if (root == null) return;
        // 如果是叶子节点，且比之前的要深
        if (root.left == null && root.right == null) {
            if (curLevel > maxLevel) { // 不能取等于号，否则可能会取到右边的叶子节点
                maxLevel = curLevel;
                ans = root.val;
            }
        }
        helper(root.left, curLevel + 1);
        helper(root.right, curLevel + 1);
    }
}
