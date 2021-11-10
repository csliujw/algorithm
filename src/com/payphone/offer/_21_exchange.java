package com.payphone.offer;

public class _21_exchange {
    public int[] exchange(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;
        // 双指针做法。
        for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
            // i指针指向奇数 j指针指向偶数

            // nums[i]是奇数的话，i++
            while (i < j && (nums[i] & 1) == 1) i++;

            // nums[j]是偶数的话，j--
            while (i < j && (nums[j] & 1) == 0) j--;
            if (i < j) swap(nums, i, j);
        }
        return nums;
    }

    public void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
