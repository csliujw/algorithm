package com.payphone.leetcode;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 哈希表判断，当前范围内是否有重复的如果有，则 start++，直到这个重复的只剩一个
 */
public class N0003LengthOfLongestSubstring {

    @Test
    public void f1() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int ans = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            // 当前的 map count++
            map[cur]++;
            // 如果发现加入当前字符后重复了，则 start 需要前进到重复的那个字符的再后面一个
            while (map[cur] > 1) {
                map[s.charAt(start++)]--;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
