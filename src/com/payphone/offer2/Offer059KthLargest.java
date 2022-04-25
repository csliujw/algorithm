package com.payphone.offer2;

import java.util.PriorityQueue;
import java.util.Queue;

// 第 k 大的元素。最后要拿到第 K 大的，用 smallHeap。
// 如果有元素比队列中的最小元素（peek）还大，则移除堆顶元素，把 newEle 加入
public class Offer059KthLargest {
    class KthLargest {
        PriorityQueue<Integer> minHeap;
        int size;

        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            size = k;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (minHeap.size() < size) {
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }
}
