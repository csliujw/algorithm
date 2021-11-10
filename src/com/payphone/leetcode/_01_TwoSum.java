package com.payphone.leetcode;

import java.util.HashMap;

public class _01_TwoSum {
    public static void main(String[] args) {
        //[3,2,4]
        //6
        _01_TwoSum leetcode = new _01_TwoSum();
        int nums[] = {2, 5, 5, 11};
        int[] ints = leetcode.twoSumHashTable(nums, 10);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r)) {
                return new int[]{map.get(r), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 两数之和 双重for，0ms,暴力。 打败100%
    public int[] twoSumFor(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // hash表 3ms，打败19.84%

    /**
     * key --> 数组中的值
     * value --> 数组索引+1
     * map中找是否存在second = target - nums的时候先判断hash中是否有，在判断是否重复利用了同一个数字
     * map.get(second) - 1 != i 不是同一个数字利用两次
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        // [3,2,4]
        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            if (map.get(second) != null && map.get(second) != 0 && map.get(second) - 1 != i) {
                return new int[]{i, map.get(second) - 1};
            }
        }
        return new int[]{};
    }

    /**
     * 这种做法成立的原因是： pren umber。。。 current 。。。next number
     * 当前数如果与前面的数字不构成 x+a = target，那么只需要在看它与后面的数能否构成了。
     * current进入了hashmap后，就会有与current后面的数进行构成的机会。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashTable2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r)) {
                return new int[]{map.get(r), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
