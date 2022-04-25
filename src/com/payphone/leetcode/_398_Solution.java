package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// 随机数索引
public class _398_Solution {
    class Solution {
        Random random;
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int meetCount = 0, ans = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    meetCount++;
                    if (random.nextInt(meetCount) == 0) ans = nums[i];
                }
            }
            return ans;
        }
    }

    class Solution1 {
        HashMap<Integer, List<Integer>> numToIndexs;
        Random random;

        public Solution1(int[] nums) {
            random = new Random();
            numToIndexs = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!numToIndexs.containsKey(nums[i])) {
                    numToIndexs.put(nums[i], new ArrayList<>());
                }
                numToIndexs.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            if (numToIndexs.containsKey(target)) {
                List<Integer> indexs = numToIndexs.get(target);
                int i = random.nextInt(indexs.size());
                return indexs.get(i);
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}
