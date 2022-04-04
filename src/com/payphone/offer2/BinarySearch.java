package com.payphone.offer2;

public class BinarySearch {
    public int binarySearch(int target, int... nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 注意，别爆 int
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearch(9, 1, 2, 3, 4, 5, 6);
        System.out.println(i);
    }
}
