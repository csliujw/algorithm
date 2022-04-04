package com.payphone.offer2;

public class _69 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]))
                return mid;
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
