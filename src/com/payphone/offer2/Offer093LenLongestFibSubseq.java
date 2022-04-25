package com.payphone.offer2;

import java.util.HashMap;
import java.util.Map;

public class Offer093LenLongestFibSubseq {
    /**
     * 状态转移方程
     * * f[i][j] 表示 i~j 范围内 最长的子串
     */
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i); // 缓存 value 对应的 index
        }
        int[][] dp = new int[len][len];
        int ans = 2; // 至少要是 3
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int key = map.getOrDefault(arr[i] - arr[j], -1);
                if (key > -1 && key < j) {
                    dp[i][j] = dp[j][key] + 1;
                } else {
                    dp[i][j] = 2;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans > 2 ? ans : 0;
    }
}
