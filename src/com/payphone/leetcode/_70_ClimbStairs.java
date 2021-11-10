package com.payphone.leetcode;

public class _70_ClimbStairs {
    public int climbStairs(int n) {
        return fun1(n);
    }

    /**
     * 如果看懂了题意会知道，这题是斐波那契数列的变形
     *
     * @param n
     */
    public int fun1(int n) {
        if (n == 1 || n == 2) return n;
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
