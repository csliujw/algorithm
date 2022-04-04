package com.payphone.offer2;

public class _72 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return mid;
            if (mid * mid > x) right = mid - 1;
            else left = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        _72 v = new _72();
        System.out.println(v.mySqrt(4));
    }
}
