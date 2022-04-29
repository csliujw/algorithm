package com.payphone.offer;

import org.junit.Test;

public class Offer042MaxSubArray {
    // f[i] = Max(f[i-1]+nums[i],nums[i])
    public int maxSubArray(int... nums) {
        int ans = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    @Test
    public void t1() {
        System.out.println(maxSubArray(-2, 1, -3, 4, -1, 2, 1, -5, 4));
    }
}
