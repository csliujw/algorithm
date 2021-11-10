package com.payphone.ds.recursion;

public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[1...n]这个区间的所有数组的和
    private static int sum(int[] arr, int l) {
        // 递归边界
        if (l == arr.length) return 0;
        // 递归表达式
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 6, 6, 5, 5, 6};
        System.out.println(Sum.sum(arr));
    }
}
