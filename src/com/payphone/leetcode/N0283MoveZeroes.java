package com.payphone.leetcode;


// https://leetcode-cn.com/problems/move-zeroes/
public class N0283MoveZeroes {
    /**
     * 实时统计 0 的个数 countZero，遇到 非 0 元素时
     * 把非 0 元素前移 countZero 个位置。
     */
    public void moveZeroes(int[] nums) {
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero += 1;
            } else {
                nums[i - countZero] = nums[i];
            }
        }
        for (int i = 0; i < countZero; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
}
