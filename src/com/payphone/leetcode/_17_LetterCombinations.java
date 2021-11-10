package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class _17_LetterCombinations {
    List<String> list = new ArrayList<>();
    private static String[] str = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        _17_LetterCombinations letterCombinations = new _17_LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("22");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * 典型的dfs
     */
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return list;
        dfs(digits, 0, "");
        return list;
    }

    void dfs(String digits, int u, String path) {
        // 如果走了指定次数，则把走过的路径追加进去
        if (u == digits.length()) list.add(path);
        else {
            String cur = str[digits.charAt(u) - '0'];
            // 否则继续遍历。
            for (int i = 0; i < cur.length(); i++) {
                dfs(digits, u + 1, path + cur.charAt(i));
            }
        }
    }
}
