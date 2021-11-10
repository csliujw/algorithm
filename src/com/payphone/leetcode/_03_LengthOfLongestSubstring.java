package com.payphone.leetcode;

public class _03_LengthOfLongestSubstring {
    // 14ms     21.82%
    // 38.9MB   24.08%
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] map = new int[65535];
        for (int i = 0, j = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            while (map[s.charAt(i)] > 1) {
                map[s.charAt(j++)]--;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
