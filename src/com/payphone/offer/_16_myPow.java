package com.payphone.offer;

public class _16_myPow {
    /**
     * 快速幂的做法（优美）
     * - 递归。
     * - x^5 = x^2 * x^2 * x
     * - 5/2=2 5%2=1 2*2*1
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {
    }
}
