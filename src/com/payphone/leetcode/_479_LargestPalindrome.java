package com.payphone.leetcode;

import org.junit.Test;

public class _479_LargestPalindrome {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) (Math.pow(10, n) - 1);

        // 构造回文数
        for (int i = max; i >= 0; i--) {
            long pre = i, next = i;
            // 开始构造回文数，为什么是 next!=0 而不是 next%10!=0,
            // 因为 next 可能回取到 10. 10%10=0，不会再算后面的？
            while (next != 0) {
                pre = pre * 10 + next % 10;
                next /= 10;
            }
            // 判断回文数，枚举到根号j就行。
            for (long j = max; j * j >= pre; j--) {
                if (pre % j == 0) return (int) (pre % 1337);
            }
        }
        // 判断回文数
        return -1;
    }

    @Test
    public void t1() {
        for (int i = 2; i <= 8; i++) {
            System.out.println(largestPalindrome(i));
        }
    }
}
