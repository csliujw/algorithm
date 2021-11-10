package com.payphone.leetcode;

public class _07_Reverse {
    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            // r + 数据后 > Integer.MAX_VALUE 的话就溢出了。
            if (r > 0 && r > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if (r < 0 && r < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}
