package com.payphone.lc.simple;

public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针
        if (numbers.length < 2) return new int[]{};
        for (int i = 0, j = numbers.length - 1; i < numbers.length; ) {
            int cut = numbers[i] + numbers[j];
            if (cut > target) {
                j--;
            } else if (cut < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }
}
