package com.payphone.leetcode;

import java.util.ArrayList;

public class _821_ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int[] ans = new int[chars.length];

        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) arrayList.add(i);
        }
        for (int i = 0; i < chars.length; i++) {
            int minShort = findMinShort(i, arrayList);
            ans[i] = minShort;
        }
        return ans;
    }

    private int findMinShort(int index, ArrayList<Integer> local) {
        int minShort = Integer.MIN_VALUE;
        int size = local.size();
        if (index == local.get(0) || index == local.get(size - 1)) return index;

        for (int i = 0; i < local.size(); i++) {
            minShort = Math.min(minShort, Math.abs(local.get(i) - index));
        }
        return minShort;
    }
}
