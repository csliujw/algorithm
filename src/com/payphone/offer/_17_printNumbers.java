package com.payphone.offer;

public class _17_printNumbers {
    // 与剑指offer的题完全不一样，都不要考虑大数问题，差评。
    public int[] printNumbers(int n) {
        // 找规律的题。且需要注意数组越界问题。
        // n=1 时 max = 9
        // n=2 时 max = 99
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        int[] arr = new int[max - 1];
        for (int i = 1; i < max; i++) {
            arr[i - 1] = i;
        }
        return arr;
    }
}
