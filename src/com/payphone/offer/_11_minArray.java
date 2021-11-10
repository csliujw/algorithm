package com.payphone.offer;

/**
 * 旋转数组的最小值
 */
public class _11_minArray {
    public static void main(String[] args) {

    }

    // 执行用时0ms 击败 100%的用户
    public int minArray(int[] numbers) {
        int min = 0X7fffffff;
        for (int i = 0; i < numbers.length; i++) {
            min = numbers[i] > min ? min : numbers[i];
        }
        return min;
    }

//    public int minArray2(int[] numbers) {
//        int min = 0X7fffffff;
//
//    }
}
