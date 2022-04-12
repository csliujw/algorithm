package com.payphone.leetcode;

public class _04_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] arr = new int[len / 2 + 2];
        int index1 = 0, index2 = 0;
        int arrIndex = 0;
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 < nums1.length && index2 < nums2.length) {
                int cur = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
                arr[arrIndex++] = cur;
            } else if (index1 < nums1.length) {
                arr[arrIndex++] = nums1[index1++];
            } else {
                arr[arrIndex++] = nums2[index2++];
            }
            if (arrIndex > len / 2) {
                if (len % 2 == 0) {
                    return (arr[len / 2] + arr[len / 2 - 1]) * 1.0 / 2;
                } else {
                    return arr[len / 2];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _04_FindMedianSortedArrays solution = new _04_FindMedianSortedArrays();
        int[] s1 = {1, 3, 4, 5, 8, 10, 20, 30};
        int[] s2 = {2, 5, 6, 8};

        System.out.println(solution.findMedianSortedArrays(s1, s2));
    }
}
