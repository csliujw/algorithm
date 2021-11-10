package com.payphone.offer;

public class _03_findRepeatNumber {
    // 代码有点绕
    public int findRepeatNumber(int[] nums) {
        // 根据数组中数据与索引的关系进行判重。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            // 拿到当前位置的数
            int number = nums[i];
            // 如果这个数（number）和numbers索引的数重复了，说明这个数就是重复数组。
            if (nums[number] == number) return number;
            else {
                // 否则，把i索引的数据和nums[i]索引的数据进行交换。
                nums[i] = nums[number];
                nums[number] = number;
            }
        }
        return -1;
    }

    public int map(int[] nums) {
        int[] map = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            if (++map[nums[i]] > 1) return nums[i];
        }
        return -1;
    }
}
