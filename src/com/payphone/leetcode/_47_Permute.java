package com.payphone.leetcode;

import org.junit.Test;

import java.util.*;

public class _47_Permute {

    @Test
    public void f1() {
        permuteUnique(1, 1, 2, 3);
    }


    public List<List<Integer>> permuteUnique(int... nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }


    // start 表示那些0~start-1 的 index 都确定了
    private void helper(int[] nums, int start, List<List<Integer>> ans) {
        if (start == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int num : nums) tmp.add(num);
            ans.add(tmp);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, start, i);
                helper(nums, start + 1, ans);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        if (from == to) return;
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

}
