package com.payphone.leetcode;

public class _771_numJewelsInStones {

    public int numJewelsInStones(String jewels, String stones) {
        int[] map = new int[128];
        for (int i = 0; i < jewels.length(); i++)
            map[jewels.charAt(i)] = -1;

        for (int i = 0; i < stones.length(); i++) {
            int tmp = stones.charAt(i);
            if (map[tmp] != 0) {
                if (map[tmp] == -1) {
                    map[tmp] = 1;
                } else {
                    map[tmp] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            int index = jewels.charAt(i);
            if (map[index] != -1) {
                count += map[index];
            }
        }
        return count;
    }
}
