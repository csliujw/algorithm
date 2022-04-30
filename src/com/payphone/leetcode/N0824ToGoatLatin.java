package com.payphone.leetcode;

import org.junit.Test;

public class N0824ToGoatLatin {

    @Test
    public void say() {
        toGoatLatin("I speak Goat Latin");
    }

    /**
     * 简而言之，根据单词的特点，对单词进行变形 "Imaa peaksmaa oatGmaaa atinLmaaaa"
     */
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        char[] helper = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder ans = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");
        transformer(ans, s[0], helper, suffix.toString());
        for (int i = 1; i < s.length; i++) {
            ans.append(" ");
            suffix.append("a");
            transformer(ans, s[i], helper, suffix.toString());
        }
        return ans.toString();
    }

    /**
     * 1.元音字母开头，再单词后加 ma
     * 2.辅音字母开头，移除第一个字符串，并放到末尾，然后加 ma
     * 3.
     */
    private void transformer(StringBuilder ans, String word, char[] helper, String suffix) {
        int length = ans.length();
        // 元开头
        for (int i = 0; i < helper.length; i++) {
            if (Character.toLowerCase(word.charAt(0)) == helper[i]) {
                ans.append(word).append("ma");
            }
        }
        // 辅开头
        if (length == ans.length()) {
            ans.append(word.substring(1)).append(word.charAt(0)).append("ma");
        }
        ans.append(suffix);
    }
}
