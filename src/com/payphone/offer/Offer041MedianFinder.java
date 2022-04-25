package com.payphone.offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Offer041MedianFinder {
    class MedianFinder {
        Queue<Integer> smallHeap, bigHeap;

        public MedianFinder() {
            // small 中多存一个
            smallHeap = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            bigHeap = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
        }

        public void addNum(int num) {
            // small = big+1,，然后又有新元素要插入
            // 则向 bigHeap 里插入一个。
            if (smallHeap.size() == bigHeap.size() + 1) {
                smallHeap.add(num);
                bigHeap.add(smallHeap.poll());
            } else {
                // small size= big size. 说明为奇数。
                // 则把元素插入大堆里，再把大堆的最大值插入到 small 里。
                // 相当于在 small 里插入了一个。small 就比 big 多一个
                bigHeap.add(num);
                smallHeap.add(bigHeap.poll());
            }
        }

        public double findMedian() {
            return smallHeap.size() != bigHeap.size() ? smallHeap.peek() : (smallHeap.peek() + bigHeap.peek()) / 2.0;
        }
    }
}