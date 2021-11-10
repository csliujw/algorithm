package com.payphone.leetcode;

public class _09_IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        String s = x + "";
        for (int i = 0, j = s.length() - 1; i <= j; ) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
