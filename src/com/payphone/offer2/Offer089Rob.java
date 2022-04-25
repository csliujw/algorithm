package com.payphone.offer2;

import java.util.Arrays;

public class Offer089Rob {
    public int rob(int... nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int left = _rob(nums, 0, len - 1);
        int right = _rob(nums, 1, len);
        return Math.max(left, right);
    }

    public int _rob(int[] nums, int from, int to) {
        if (to - from == 0) return 0;
        if (to - from == 1) return Math.max(nums[from], nums[to]);
        int f1 = nums[from];
        int f2 = Math.max(nums[from], nums[from + 1]);
        for (int i = from + 2; i < to; i++) {
            int tmp = Math.max(f1 + nums[i], f2);
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }

    // fi = Max(fi-2+nums[i],fi-1)
    // 死递归
    public void helper(int[] nums, int cur, int[] dp) {
        if (dp[cur] == -1) {
            helper(nums, cur - 2, dp);
            helper(nums, cur - 1, dp);
            dp[cur] = Math.max(dp[cur - 2] + nums[cur], dp[cur - 1]);
        }
    }

    public static void main(String[] args) {
        Offer089Rob offer089Rob = new Offer089Rob();
        System.out.println(offer089Rob.rob(1, 2, 3, 1));
    }
}
