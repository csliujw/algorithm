package com.payphone.offer2;

import java.util.Arrays;

public class Offer088 {
    //f_i= min(f_i-1,f_i-2)+cost[i]
    // 始终只有前两个会影响后面的结果
    public int minCostClimbingStairs(int... cost) {
        int len = cost.length;
        int f1 = cost[0], f2 = cost[1];
        for (int i = 2; i < len; i++) {
            int tmp = Math.min(f1, f2) + cost[i];
            f1 = f2;
            f2 = tmp;
        }
        return Math.min(f1, f2);
    }

    private void helper(int[] cost, int cur, int[] dp) {
        if (dp[cur] == 0) {
            helper(cost, cur - 1, dp);
            helper(cost, cur - 2, dp);
            dp[cur] = Math.min(dp[cur - 1], dp[cur - 2]) + cost[cur];
        }
    }


    public static void main(String[] args) {
        Offer088 offer088 = new Offer088();
        System.out.println(offer088.minCostClimbingStairs(1, 100, 1, 1, 1, 100, 1, 1, 100, 1));
    }
}
