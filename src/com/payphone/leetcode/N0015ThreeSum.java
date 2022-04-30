package com.payphone.leetcode;

import java.util.*;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class N0015ThreeSum {
    // 排序+双指针。
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // Set 去重
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 固定 i，找符合要求的 j k
            System.out.println(i);
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            // 去除一部分重复的 i。提高速度。
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return new LinkedList<>(ans);
    }

    // 排序+双指针，可以不用 set 判重

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 当前的元素和上一个重复了，直接跳过、
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    ans.add(makeList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ans;
    }

    public List<Integer> makeList(int... T) {
        LinkedList<Integer> retVal = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            retVal.add(T[i]);
        }
        return retVal;
    }

}
