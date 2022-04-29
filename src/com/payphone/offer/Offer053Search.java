package com.payphone.offer;

import org.junit.Test;

import java.util.Arrays;

public class Offer053Search {
    public int search(int[] nums, int target) {
        return searchRight(nums, target) - searchLeft(nums, target);
    }


    @Test
    public void f1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        searchLeft(nums, 8);
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1; // 可以找到 target 右边的一个数
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
