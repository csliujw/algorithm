package com.payphone.offer2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Offer033GroupAnagrams {

    // 一对变位词组
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cur = str.toCharArray();
            Arrays.sort(cur);
            // 如果不存在该 key，则把 value LinkedList 放进去。存在该 key 的话，就不放
            LinkedList<String> list = map.putIfAbsent(String.valueOf(cur), new LinkedList<>());
            list.add(str);
        }
        return new LinkedList<>(map.values());
    }
}
