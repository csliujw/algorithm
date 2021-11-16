package com.payphone.offer;

import java.util.*;
import java.util.stream.Stream;


public class _03_findRepeatNumber {
    // 代码有点绕
    public int findRepeatNumber(int[] nums) {
        // 遍历，把数据放到合适的位置
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) { // 数据和索引对不少号，则进行交换
                // 拿到数组中的元素i，把这个元素i放到索引i处
                if (nums[i] == nums[nums[i]]) return nums[i];
                else swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public int map(int[] nums) {
        int[] map = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (++map[nums[i]] > 1) return nums[i];
        }
        return -1;
    }

    /**
     * 使用 hashset 判重
     *
     * @param nums
     * @return
     */
    public int useMap(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(i)) {
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        _03_findRepeatNumber find = new _03_findRepeatNumber();
        int[] list = {2, 3, 5, 4, 3, 2, 6, 7, 7};
        System.out.println(find.getDup(list));
    }


    public int[] printNumbers(int n) {
        // write code here
        long max = 0;
        if (n == 3) max = (int) Math.pow(10, 3) - 1;
        int ret[] = new int[(int) max];
        for (int i = 1; i <= max; i++) {
            ret[i - 1] = 1;
        }
        return ret;
    }

    /**
     * 在一个长度为 n+1 的数组里所有数字都在 1~n 范围内，不修改数组找出重复的数字。
     */
    public int getDup(int[] arr) {
        int start = 1, end = arr.length - 1;
        // 统计 start ~ end / 2 范围内数字出现的次数
        int mid = start + end >> 1;
        while (start < end) {
            if (search(arr, start, mid) > mid - start + 1) {
                end = mid;
                mid = start + mid >> 1;
            } else {
                start = mid + 1;
                mid = end;
            }
        }
        return end;
    }

    private int search(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }

}
