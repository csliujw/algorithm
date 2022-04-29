package com.payphone.offer;

import org.junit.Test;

public class Offer053MissingNumber {


    @Test
    public void f1() {
        System.out.println(missingNumber(0, 1, 2, 3, 4, 5, 6, 7, 9));
    }

    public int missingNumber(int... nums) {
        if (nums[0] != 0) return 0;
        if (nums[nums.length - 1] != nums.length) return nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[left] + nums[mid] > left + mid) { // 说明缺失的数字就在这里
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (nums[left] + nums[right]) / 2;
    }
}
