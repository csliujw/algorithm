package com.payphone.leetcode;

public class N0011MaxArea {
    public static void main(String[] args) {
        int[] s = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        N0011MaxArea maxArea = new N0011MaxArea();
        int i = maxArea.maxArea(s);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i <= j; ) {
            int start = height[i];
            int end = height[j];
            int t = (start > end) ? end * (j - i) : start * (j - i);
            max = max > t ? max : t;
            if (start >= end) j--;
            else i++;
        }
        return max;
    }
}
