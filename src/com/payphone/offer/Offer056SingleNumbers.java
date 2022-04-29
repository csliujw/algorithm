package com.payphone.offer;

import org.junit.Test;

public class Offer056SingleNumbers {
    /**
     * 先判断是否有两个只出现一次的数字。
     * 如果是只有一个的话，可以用异或找出来。
     */
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans ^= nums[i];
            }
            int bit = 0;
            while ((ans & 1) != 1) {
                ans = ans >> 1;
                bit++;
            }
            int an1 = 0, an2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    an1 ^= nums[i];
                } else {
                    an2 ^= nums[i];
                }
            }
            return new int[]{an1, an2};
        }
    }
}
