package com.payphone.leetcode;

// https://www.acwing.com/problem/content/73/
// leetcode做了加强，字符之间会有多个空格，需要先进行多余空格的去除
public class Acwing077ReverseWords {

    public static void main(String[] args) {
        String liujiawei = reverseWords("  liujiawei hello  ");
        System.out.println(liujiawei);
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length);
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {

                reverse(chars, start, i);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int length) {
        for (int i = start, j = length - 1; i <= j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
