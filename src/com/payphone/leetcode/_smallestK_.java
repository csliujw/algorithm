package com.payphone.leetcode;

import java.util.PriorityQueue;

public class _smallestK_ {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        System.out.println(priorityQueue.peek());
        int[] retVal = new int[k];
        for (int i = 0; i < priorityQueue.size(); i++) {
            retVal[i] = priorityQueue.poll();
        }
        return retVal;
    }

    public static void main(String[] args) {
        _smallestK_ smallestK_ = new _smallestK_();
        int[] a = {1, 2, 3123, 13, 123, 123, 23, 123};
        smallestK_.smallestK(a, 3);
    }
}
