package com.payphone.leetcode;

public class _190_ReverseBits {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            // n>>i & 1 找到 n中第i位的数是什么。
            ret = (ret << 1) + (n >> i & 1);
        }
        return ret;
    }
}
