package com.payphone.leetcode;

import org.junit.Test;

public class _125_IsPalindrome {

    @Test
    public void f1() {
        System.out.println(isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (Character.isLetterOrDigit(chars[start]) && Character.isLetterOrDigit(chars[end])) {
                if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) return false;
                start++;
                end--;
            } else if (!Character.isLetterOrDigit(chars[start])) {
                start++;
            } else if (!Character.isLetterOrDigit(chars[end])) {
                end--;
            }
        }
        return true;
    }

}
