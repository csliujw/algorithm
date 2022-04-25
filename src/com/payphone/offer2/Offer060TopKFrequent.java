package com.payphone.offer2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Offer060TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> numToCount = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });

        for (int i = 0; i < nums.length; i++) {
            numToCount.put(nums[i], numToCount.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = numToCount.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        for (int i = 0, len = minHeap.size(); i < len; i++) {
            ans[i] = minHeap.poll().getKey();
        }
        return ans;
    }
}
