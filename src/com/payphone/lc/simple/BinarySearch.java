package com.payphone.lc.simple;

import org.junit.Test;

public class BinarySearch {
    // 在 arr 中寻找 target
    @Test
    static int binarySearch(Integer arr[], int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) { // l==r 时依旧是有效的查找
            // 0   8  --
            // 4,8
            // 4+4
            int mid = l + (r - l) / 2;
            System.out.println(mid);
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static <T> T[] of(T... t) {
        return t;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(of(1, 2, 3, 4, 5, 6, 7, 8, 10), 10));
    }
}
