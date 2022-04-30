package com.payphone.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/two-sum/
public class N0001TwoSum {
    // hash 表来做
    // 找 target-cur 是否存在于 hash 表中。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
