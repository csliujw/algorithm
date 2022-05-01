package com.payphone.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class N0290 {

    @Test
    public void t1() {
        /**
         * "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
         * "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
         */
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern2("abba", "dog cat cat dog"));
    }

    // 双 hashmap
    public boolean wordPattern(String pattern, String s) {
        String[] text = s.split(" ");
        if (text.length != s.length()) return false;
        Map<String, Character> strToChar = new HashMap<>();
        Map<Character, String> charToStr = new HashMap<>();
        for (int i = 0; i < text.length; i++) {
            // 都不包含，则添加
            if (!strToChar.containsKey(text[i]) && !charToStr.containsKey(pattern.charAt(i))) {
                strToChar.put(text[i], pattern.charAt(i));
                charToStr.put(pattern.charAt(i), text[i]);
            } else {
                // 有包含的，看是否 str->char  char->str 能否对应上
                Character character = strToChar.get(text[i]);
                String s1 = charToStr.get(pattern.charAt(i));
                if (character != pattern.charAt(i) || !text[i].equals(s1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 单 hashmap error
    public boolean wordPattern2(String pattern, String str) {
        String[] text = str.split(" ");
        if (text.length != pattern.length()) return false;
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < text.length; i++) {
            if (map.put(text[i], i) != map.put(pattern.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern3(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
