package com.payphone.leetcode;

public class _26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // 双指针。 与80类似
        if (nums.length <= 1) return nums.length;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) nums[k++] = nums[i];
        }
        return k;
    }
}
