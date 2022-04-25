package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _442_FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[100000 + 2];
        for (int i = 0; i < nums.length; i++) {
            if (map[nums[i]] == 0) map[nums[i]] = 1;
            else {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
