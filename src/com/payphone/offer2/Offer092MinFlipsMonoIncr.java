package com.payphone.offer2;

public class Offer092MinFlipsMonoIncr {
    // 看看能不能一遍 ac
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        // 直接统计即可
        int[][] dp = new int[s.length()][2];
        dp[0][0] = (chars[0] == '1' ? 1 : 0);
        dp[0][1] = (chars[0] == '0' ? 1 : 0);
        for (int i = 1; i < chars.length; i++) {
            dp[i][0] = dp[i - 1][0] + (chars[i] == '1' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (chars[i] == '1' ? 0 : 1);
        }
        return Math.min(dp[chars.length - 1][0], dp[chars.length - 1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Offer092MinFlipsMonoIncr().minFlipsMonoIncr("010100"));
    }
}
