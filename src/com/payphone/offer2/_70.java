package com.payphone.offer2;

public class _70 {
    // 直接异或
    public int singleNonDuplicate(int... nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    // 二分查找
    public int singleNonDuplicate2(int... nums) {
        int left = 0, right = nums.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid * 2;
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                right = mid - 1;
                if (mid == 0 || nums[i - 1] == nums[i - 2]) return nums[i];
            } else {
                left = mid + 1;
            }
            // 找到二分的条件
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        _70 v = new _70();
        System.out.println(v.singleNonDuplicate2(1, 1, 2, 2, 3, 3, 4));
    }
}
