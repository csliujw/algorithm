package com.payphone.leetcode;

import org.junit.Test;

import java.util.*;

public class N0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String... strs) {
        // 排序+判断
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            map.put(s, list);
        }
        Collection<List<String>> values = map.values();
        LinkedList<List<String>> lists = new LinkedList<>(values);
        return lists;
    }

    @Test
    public void t1() {
        groupAnagrams("eat", "tea", "tan", "ate", "nat", "bat");
    }
}
