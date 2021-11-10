package com.payphone.leetcode;

import java.util.PriorityQueue;

public class _215_findKthLargest {

    public static void main(String[] args) {
        _215_findKthLargest findKthLargest = new _215_findKthLargest();
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        findKthLargest.findKthLargest(array, k);

    }


    public int findKthLargest(int[] nums, int k) {
        // 小顶堆 顶上的是最小的
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> {
            return (o1 - o2);
        });
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            } else {
                priorityQueue.add(nums[i]);
            }
        }
        System.out.println(priorityQueue.peek());
        return priorityQueue.peek();
    }
}
