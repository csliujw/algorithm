package com.payphone.leetcode;

public class N0005LongestPalindrome {
    /**
     * 双指针做 / DP做（空间复杂度比双指针（枚举）高）
     * 确定中心，往两边走，只要两个字符不一样，就停止搜索。
     * left mid right
     * 1. 长度为奇数 left = r-1 ==== right = r+1
     * 2. 长度为偶数 left = r === right = r+1
     */
    public String longestPalindrome1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left - 1) res = s.substring(left + 1, right);
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left - 1) res = s.substring(left + 1, right);
        }
        return res;
    }


    public String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 长度为奇数时
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left - 1) res = s.substring(left + 1, right);
            // 长度为偶数时
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left - 1) res = s.substring(left + 1, right);
        }
        return res;
    }
}
