package com.payphone.leetcode;

public class N0383CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        // magazine 里面的字符要比 ransomNote 里多
        if (ransomNote.length() > magazine.length()) return false;
        int[] map = new int[26];
        int len = ransomNote.length();
        for (int i = 0; i < len; i++) {
            map[ransomNote.charAt(i) - 'a']--;
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = len; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] < 0) return false;
        }
        return true;
    }
}
