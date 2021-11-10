package com.payphone.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _217_containsDuplicate {
    public static void main(String[] args) {
        // 存在重复元素
    }

    // 先排序，再判重
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    // hash 判重
    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (map.containsKey(nums[i])) return true;
            else map.put(nums[i], 1);
        }
        return false;
    }
}
