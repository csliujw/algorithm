package com.payphone.leetcode;

// https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
public class N0167TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针
        int len = numbers.length;
        if (len < 2) return new int[]{};
        for (int i = 0, j = len - 1; i < len; ) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }
}
