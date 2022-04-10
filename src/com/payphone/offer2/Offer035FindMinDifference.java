package com.payphone.offer2;

import java.util.Arrays;
import java.util.List;

public class Offer035FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] nums = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] cur = timePoints.get(i).split(":");
            nums[i] = Integer.parseInt(cur[0]) * 60 + Integer.parseInt(cur[1]);
        }
        Arrays.sort(nums);
        int min = 0xfffff;
        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(Math.abs(nums[i] - nums[i + 1]), min);
        }
        // 首位时间差
        min = Math.min(min, nums[0] - nums[nums.length - 1] + 60 * 24);
        return min;
    }

    public int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;
        boolean[] map = new boolean[1440];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":");
            int indexOf = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (map[indexOf]) return 0;
            map[indexOf] = true;
        }
        return helper(map);
    }

    private int helper(boolean[] flag) {
        int minDiff = flag.length - 1;
        int pre = -1;
        int first = flag.length - 1;
        int last = -1;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                if (pre >= 0) minDiff = Math.min(i - pre, minDiff);
                pre = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }
        minDiff = Math.min(first + flag.length - last, minDiff);
        return minDiff;
    }

    public static void main(String[] args) {
        Offer035FindMinDifference solution = new Offer035FindMinDifference();
        int minDifference = solution.findMinDifference2(Arrays.asList("01:01", "02:01"));
        System.out.println(minDifference);
    }
}
