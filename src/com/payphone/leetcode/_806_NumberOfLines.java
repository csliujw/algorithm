package com.payphone.leetcode;

public class _806_NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        // 写上这个字母，不超过 100 行就写，超过了就下一行。
        int currentWidth = 0;
        for (int i = 0; i < s.length(); i++) {
            ans[1] += widths[s.charAt(i) - 'a'];
            // 长度超过 100，就换行。且 currentWidth 重置为 cur+num > 100 的那个 num
            if (ans[1] > 100) {
                ans[0]++;
                ans[1] = widths[s.charAt(i) - 'a'];
            }
        }
        if (ans[1] != 0) ans[0]++;
        return ans;
    }
}
