package com.payphone.leetcode;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 */
public class N0633JudgeSquareSum {
    // 也可以看成一个两数之和。
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int start = 0, end = (int) Math.sqrt(c);
        while (start <= end) {
            long total = start * start + end * end;
            if (total > c) end--;
                // 避免 total 计算的结果溢出。
            else if (total < 0) end--;
            else if (total < c) start++;
            else return true;
        }
        return false;
    }
}
