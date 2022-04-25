package com.payphone.offer2;

import java.util.*;

public class Offer061KSmallestPairs {

    public void addToQueue(PriorityQueue<List<Integer>> queue, List<Integer> ele, int size) {
        if (queue.size() < size) {
            queue.add(ele);
        } else if (ele.get(0) + ele.get(1) < queue.peek().get(0) + queue.peek().get(1)) {
            queue.poll();
            queue.add(ele);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new LinkedList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((e1, e2) -> {
            return -(e1.get(0) + e1.get(1) - e2.get(0) - e2.get(1));
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> tmp = Arrays.asList(nums1[i], nums2[j]);
                addToQueue(queue, tmp, k);
            }
        }

        for (int i = 0, len = queue.size(); i < len; i++) {
            ans.add(queue.poll());
        }
        return ans;
    }
}
