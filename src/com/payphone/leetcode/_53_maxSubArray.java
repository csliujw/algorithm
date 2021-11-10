package com.payphone.leetcode;

public class _53_maxSubArray {
    public static void main(String[] args) {
        _53_maxSubArray maxSubArray = new _53_maxSubArray();
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray.maxSubArray(array));
    }

    public int maxSubArray(int[] nums) {
        int f_pre = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            f_pre = Math.max(f_pre, 0) + nums[i];
            max = max > f_pre ? max : f_pre;
        }
        return max;
    }

    public int max(int[] nums) {
        int res = Integer.MIN_VALUE;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            int now = Math.max(last, 0) + nums[i];
            res = Math.max(res, now);
            last = now;
        }
        return res;
    }
}
