package com.payphone.offer2;

// 有效的变位词
public class Offer032IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map1[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
