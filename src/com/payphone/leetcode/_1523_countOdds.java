package com.payphone.leetcode;

public class _1523_countOdds {

    public static void main(String[] args) {
    }

    public int countOdds1(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if ((i & 1) != 0) count++;
        }
        return count;
    }

    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low) / 2;
    }
}
