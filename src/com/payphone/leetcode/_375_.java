package com.payphone.leetcode;

import java.util.ArrayList;

public class _375_ {
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            if (res.length() != 0) {
                res.append(" " + s.substring(i + 1, j + 1)); // 添加单词
            } else {
                res.append(s.substring(i + 1, j + 1)); // 添加单词
            }
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        String s = " hello world  java    ";
        s = s.trim();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') continue;
            characters.add(s.charAt(i));
        }
        if (s.charAt(s.length() - 1) != ' ') characters.add(s.charAt(s.length() - 1));
        String retVal = "";
        // hello world java
//        characters.forEach(System.out::print);
        String tmp = "";
        // hello world java
        int count = 0;
        for (int i = 0; i < characters.size(); i++, count++) {
            if (characters.get(i) != ' ') tmp += characters.get(i);
            else {
                retVal = tmp + " " + retVal;
                tmp = "";
            }
        }
        for (int i = count; i < characters.size(); i++) {
            tmp += characters.get(i);
        }
        retVal = tmp + " " + retVal;
        System.out.println(retVal);
    }

    /*
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= n; k++) {
                    f[i][j] = k + Math.min(f[i][j], Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
    */
    private int[][] dp;

    private int solve(int left, int right) {
        //不合法时，或者只有一个数为一组时，返回0
        if (left >= right) return 0;

        //说明dp[left][right]被计算过了，返回需要的dp[left][right]结果。
        if (dp[left][right] != Integer.MAX_VALUE) return dp[left][right];

        for (int i = left; i <= right; i++) {
            //核心，动态规划
            dp[left][right] = Math.min(dp[left][right], Math.max(i + solve(left, i - 1), i + solve(i + 1, right)));
        }
        return dp[left][right];
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1; //  区间dp固定写法
                dp[i][j] = 0x7fffffff;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }


}
