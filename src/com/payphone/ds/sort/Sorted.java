package com.payphone.ds.sort;

/**
 * 排序模板
 * 快排最难的是划分<br>
 * 归并最难的是合二为一<br>
 */
public class Sorted {

    public static void main(String[] args) {
        Sorted sorted = new Sorted();
        int[] arr = {3, 1, 2, 3, 4, 54, 4, 3, 31, 4};
        int[] tmp = new int[arr.length];
        sorted.quick2(arr, 0, arr.length - 1);
//        sorted.merge(arr, tmp, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void quick2(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = array[left], i = left - 1, j = right + 1;
        while (i < j) {
            do i++; while (array[i] < mid);
            do j--; while (array[j] > mid);
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        quick2(array, left, j);
        quick2(array, j + 1, right);
    }


    // java里一定要用buffRead 不要用scanner
    public void quick(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = array[left + right >> 1], i = left - 1, j = right + 1;
        while (i < j) {
            while (array[++i] < mid) ;
            while (array[--j] > mid) ;
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        quick(array, left, j);
        quick(array, j + 1, right);
    }

    // 归并排序 == 分治
    // 以中间点为分界线。
    // 递归排序左边和右边。把两个有序的数组合并成一个有序的数组。
    // 1.确定分界点 mid.
    // 2.合二为一
    // 3.用双指针做。找出两个数组中剩下的最小值~

    public void merge(int[] array, int[] tmp, int left, int right) {
        // 当前区间只有一个数或者没有数 不用排序。
        if (left >= right) return;
        // 取区间的重点
        int mid = left + right >> 1;
        // 递归排序左边，递归排序右边
        merge(array, tmp, left, mid);
        merge(array, tmp, mid + 1, right);
        // 归并的过程，把两个有序的序列归并，结果放到tmp（临时数组）里去
        // i指向左半边有序序列的起点，j指向右半边有序序列的起点
        int k = 0, i = left, j = mid + 1;
        // 左右半边都未循环结束的时候
        while (i <= mid && j <= right)
            if (array[i] <= array[j]) tmp[k++] = array[i++];
            else tmp[k++] = array[j++];
        // 还剩左半边
        while (i <= mid) tmp[k++] = array[i++];
        // 还剩右半边
        while (j <= right) tmp[k++] = array[j++];
        // 有序序列放入array中。
        for (i = left, j = 0; i <= right; i++, j++) array[i] = tmp[j];

    }
}
