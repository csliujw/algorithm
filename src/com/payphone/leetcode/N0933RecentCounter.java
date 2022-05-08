package com.payphone.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class N0933RecentCounter {

    Queue<Integer> queue;

    public N0933RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
}
