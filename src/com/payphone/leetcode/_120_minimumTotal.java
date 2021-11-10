package com.payphone.leetcode;

import java.util.List;

/**
 * 求某一堆东西中的最大值
 * [1]
 * [1 2 3]
 * [1 5 6 9]
 * [5 6 9 8 7]
 */
public class _120_minimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            // <=i的原因好像是避免一个问题。当前点上方的dp[i-1][j] == 0的情况，
            for (int j = 0; j <= i; j++) {
                int nums = triangle.get(i).get(j);
                dp[i][j] = 0xfffffff;
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + nums);
                if (j < i) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + nums);
            }
        }
        int retVal = 0xfffffff;
        for (int i = 0; i < n; i++) {
            retVal = Math.min(retVal, dp[n - 1][i]);
        }
        return retVal;
    }
}
