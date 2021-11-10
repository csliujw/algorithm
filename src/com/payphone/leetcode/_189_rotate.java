package com.payphone.leetcode;

public class _189_rotate {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        // 做法是 ab -> ba
        // (a^T b^T)^T = ba 大致思路是这样的。
        // 后k个，翻转
        int length = nums.length;
        for (int i = length - k, j = length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = 0, j = length - k - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
