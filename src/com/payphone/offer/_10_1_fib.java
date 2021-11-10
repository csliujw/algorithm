package com.payphone.offer;

public class _10_1_fib {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int f0 = 0;
        int f1 = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
