package com.payphone.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0438FindAnagrams {
    // s long，p short
    // HashMap 暴力匹配
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;
        int[] map = new int[26];
        int[] count = new int[26];

        // 预先记录一些字符的出现频率
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++; // 0 1 2
            count[s.charAt(i) - 'a']++; // 0 1 2
        }
        if (Arrays.equals(map, count)) {
            ans.add(0);
        }
        // 继续检索还未记录的。使用双指针。start 指向最前面那个即将被移除的，i 指向即将被加入的
        for (int i = p.length(), start = 0; i < s.length(); i++, start++) {
            count[s.charAt(i) - 'a']++;
            count[s.charAt(start) - 'a']--;
            if (Arrays.equals(map, count)) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }

    @Test
    public void f1() {
        findAnagrams("cbaebabacd", "abc");
    }
}
