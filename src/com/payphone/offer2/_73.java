package com.payphone.offer2;

public class _73 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = -1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getHours(piles, mid) <= h) {
                // 看下是不是符合要求
                if (mid==1 || getHours(piles, mid - 1) > h) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 计算吃的速度
    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile+speed-1) / speed;
            /**
             * hours+=pile / speed
             * hours+=pile % speed > 0?1:0
             */
        }
        return hours;
    }

    public static void main(String[] args) {
        _73 v = new _73();
        int[] s = {10, 15, 16, 18};
        System.out.println(v.getHours(s, 8));
    }
}
