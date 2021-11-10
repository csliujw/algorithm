package com.payphone.leetcode;

/**
 * 删除重复出现的元素
 */
public class _80_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // 双指针做法。一个维护可保留的元素，一个进行元素扫描。
        // 数组已经有序
        if (nums.length <= 2) return nums.length;
        int k = 2; // 0 1 索引位置的元素不用管，不会出问题的。所以从索引2开始。
        for (int i = 2; i < nums.length; i++) {
            // nums[i] 和 nums[k-2] 不相等，说明可保留元素中至多有一个元素和nums[i]相等,nums[i]可以
            // 被加进可保留元素部分。
            if (nums[i] != nums[k - 2]) nums[k++] = nums[i];
        }
        return k;
    }
}
