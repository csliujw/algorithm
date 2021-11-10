package com.payphone.leetcode;

public class _961_repeatedNTimes {
    public int repeatedNTimes(int[] A) {
        int[] map = new int[100001];
        int max = 0;
        int number = -1;
        for (int i = 0; i < A.length; i++) {
            map[A[i]]++;
            if (max < map[A[i]]) {
                number = A[i];
                max = map[A[i]];
            }
        }
        return number;
    }
}
