package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _386_LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList();
        String[] str = new String[n];
        for (int i = 1; i <= n; i++) {
            str[i - 1] = String.valueOf(i);
        }
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            ans.add(Integer.parseInt(str[i]));
        }
        return ans;
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1, j = 1; i <= n; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                // 如果 j 要进位了，或 j 大于当前的 max 了，那么退回最原始的个位数字
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _386_LexicalOrder lexicalOrder = new _386_LexicalOrder();
        lexicalOrder.lexicalOrder2(110);
    }
}
