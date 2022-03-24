package com.payphone.lc.simple;

import java.util.Arrays;

public class MoveZero_283 {
    // [0 1 0 3 12]
    public void moveZeroes(int... nums) {
        int contZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                contZero += 1;
            } else {
                nums[i - contZero] = nums[i];
            }
        }
        for (int i = 0; i < contZero; i++) {
            nums[nums.length - 1 - i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZero_283 moveZero_283 = new MoveZero_283();
        moveZero_283.moveZeroes(0, 10, 20, 0, 30, 1, 0, 0, 0);
    }
}
