package com.payphone.leetcode;

public class _28_StrStr {
    // 暴力求解。
    // 一个一个比
    public int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals("")) return 0;
        for (int i = 0; i < haystack.length() - needle.length()+1; i++) {
            boolean isOk = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        _28_StrStr strStr = new _28_StrStr();
        /**
         */
        System.out.println(strStr.strStr("a", "a"));
    }
}
