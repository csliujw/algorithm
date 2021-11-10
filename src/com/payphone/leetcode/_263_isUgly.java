package com.payphone.leetcode;

public class _263_isUgly {
    public static void main(String[] args) {
        System.out.println(5 % 2); // 1
        System.out.println(4 % 2); // 0
    }

    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1) return true;
        while (true) {
            while (num % 2 == 0) num = num >> 1;
            while (num % 3 == 0) num /= 3;
            while (num % 5 == 0) num /= 5;
            if (num == 1) return true;
            return false;
        }
    }
}
