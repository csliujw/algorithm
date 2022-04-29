package com.payphone.offer;

import java.util.PriorityQueue;

public class Offer054KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return minHeap.peek();
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        if (minHeap.size() < k) {
            minHeap.offer(root.val);
        } else if (minHeap.peek() < root.val) {
            minHeap.poll();
            minHeap.offer(root.val);
        }
        dfs(root.right, k);
    }
}
