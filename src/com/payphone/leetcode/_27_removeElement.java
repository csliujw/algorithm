package com.payphone.leetcode;

public class _27_removeElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        // i从0开始。
        // j扫描，不为val的，覆盖，为val的不管。
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
