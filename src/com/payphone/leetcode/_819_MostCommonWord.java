package com.payphone.leetcode;

import java.util.*;

public class _819_MostCommonWord {
    // 找出未出现再 banned 中次数最多的单词。一个 HashMap 的简单题
    public String mostCommonWord(String s, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned) set.add(b);
        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ) {
            // 找出第一个是字母的字符
            if (!Character.isLetter(cs[i]) && ++i >= 0) continue;
            int j = i;
            // 定位字符串的范围
            while (j < n && Character.isLetter(cs[j])) j++;
            // 截取字符串
            String sub = s.substring(i, j).toLowerCase();
            i = j + 1;
            // 存在于 banned 中则不统计
            if (set.contains(sub)) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) ans = sub;
        }
        return ans;
    }

    public static void main(String[] args) {
        _819_MostCommonWord mostCommonWord = new _819_MostCommonWord();
        String[] banned = {};
        String str = "a, a, a, a, b,b,b,c, c";
        System.out.println(mostCommonWord.mostCommonWord(str, banned));
    }
}
