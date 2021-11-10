package com.payphone.leetcode;

public class _702_search {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // 数据小了，查左边
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                // 数据大了 查右边
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
