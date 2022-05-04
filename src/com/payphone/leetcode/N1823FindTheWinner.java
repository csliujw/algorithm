package com.payphone.leetcode;

/**
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 约瑟夫环问题
 */
public class N1823FindTheWinner {
    public int findTheWinner(int n, int k) {
        // 暴力模拟
        boolean marked[] = new boolean[n];
        int remind = n;
        int cur = 0;
        while (remind != 1) {

            for (int i = 1; i < k; i++) {
                cur++;
                // 如果这个点被淘汰了，则我们需要找到一个未被淘汰的点
                while (marked[cur]) cur++;
            }
            // 淘汰这个点
            marked[cur % n] = false;
            cur++;
            remind--;
            while (marked[cur]) cur++;
        }
        return (cur % n) + 1;
    }
}
