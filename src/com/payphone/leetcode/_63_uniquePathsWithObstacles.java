package com.payphone.leetcode;

public class _63_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] g) {
        int n = g.length, m = g[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                } else {
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
