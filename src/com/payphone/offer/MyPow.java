package com.payphone.offer;

/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(4 & 1); // 偶数与 结果是0
        System.out.println(5 & 1); // 奇数与 结果是1

        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.0, 5));
    }

    public double myPow(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if (exponent == -1) return 1 / base;
        // 奇数就是 2次half * 多余的mod
        double half = myPow(base, exponent >> 1);
        double mod = myPow(base, exponent % 2);
        return half * half * mod;
    }
}
