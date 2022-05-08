package com.payphone.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 */
public class N0345ReverseVowels {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && !isOk(chars[start])) start++;
            while (end > start && !isOk(chars[end])) end--;
            if (end > start) {
                char tmp = chars[end];
                chars[end] = chars[start];
                chars[start] = tmp;
                end--;
                start++;
            }
        }
        return new String(chars);
    }

    private boolean isOk(char c) {
        switch (c) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
