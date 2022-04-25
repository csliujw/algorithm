package com.payphone.offer2;

public class Offer091MinCost {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int dp[][] = new int[2][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][(j + 1) % 3], dp[(i - 1) % 2][(j + 2) % 3]) + costs[i][j];
            }
        }
        int last = (costs.length - 1) % 2;
        return Math.min(dp[last][0], Math.min(dp[last][1], dp[last][2]));
    }

    public static void main(String[] args) {
        Offer091MinCost offer091MinCost = new Offer091MinCost();
        int[][] s = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}, {5, 4, 6}};
        System.out.println(offer091MinCost.minCost(s));
    }
}
