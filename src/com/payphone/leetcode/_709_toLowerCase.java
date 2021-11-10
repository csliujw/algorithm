package com.payphone.leetcode;

public class _709_toLowerCase {
    public static void main(String[] args) {
        System.out.println('a' - 'A');
        System.out.println('z');

        System.out.println('A');
        System.out.println('Z');
        _709_toLowerCase toLowerCase = new _709_toLowerCase();
        System.out.println(toLowerCase.toLowerCase("AsfsfAsf"));
    }

    public String toLowerCase(String str) {
        // StringBuilder效率远高于String拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= 'A' && tmp <= 'Z') {
                sb.append((char) (tmp + 32));
            } else {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}
