package com.payphone.leetcode;

import java.util.HashMap;

public class _804_UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String... words) {
        String[] password = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            // 存在的话会返回 value，不存在会返回 null，不存在，计数器++
            if (map.putIfAbsent(toPassword(words[i], password), true) == null) {
                count++;
            }
        }
        return count;
    }

    private String toPassword(String str, String[] password) {
        StringBuilder retVal = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            retVal.append(password[str.charAt(i) - 'a']);
        }
        return retVal.toString();
    }

    public static void main(String[] args) {
        _804_UniqueMorseRepresentations demo = new _804_UniqueMorseRepresentations();
        System.out.println(demo.uniqueMorseRepresentations("gin", "sfafsfsfzen", "gin", "msg"));
    }
}
