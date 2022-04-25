package com.payphone.offer2;

import java.util.ArrayList;
import java.util.List;

public class Offer083Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ans) {
        if (nums.length == index) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            ans.add(tmp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 确定一个位置的元素
            swap(nums, index, i);
            helper(nums, index + 1, ans);
            // 复原
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int from, int to) {
        if (from == to) return;
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
