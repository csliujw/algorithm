package com.payphone.offer2;

import java.util.LinkedList;

public class Offer041MovingAverage {
    static class MovingAverage {
        LinkedList<Integer> queue;
        int size;
        double ans = 0;

        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() < size) {
                queue.add(val);
                ans += val;
            } else {
                ans -= queue.remove();
                queue.add(val);
                ans += val;
            }
            return ans / queue.size();
        }
    }
}