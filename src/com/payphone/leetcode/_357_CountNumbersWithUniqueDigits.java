package com.payphone.leetcode;

public class _357_CountNumbersWithUniqueDigits {
    static int[] map = new int[10];
    static int count = 0;

    public int countNumbersWithUniqueDigits(int n) {
        count = 0;
        if (n == 0) return 1;
        dfs(n, 0);
        return count;
    }


    /**
     * 能不能 dfs 来做
     * n = 0 return 1
     * n = 1,只有一位。return 10
     * n = 2,两位的数字。第一位可以放 1~9，第二位可以放 0~9
     */
    private void dfs(int n, int curIndex) {
        if (curIndex >= n) return;
        int i = 0;
        if (curIndex == 0) i = 1;
        // 最高位只能为 1~9
        for (; i <= 9; i++) {
            if (map[i] == 0) {
                count++;
                map[i] = 1;
                dfs(n, curIndex + 1);
                map[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _357_CountNumbersWithUniqueDigits ans = new _357_CountNumbersWithUniqueDigits();
        System.out.println(ans.countNumbersWithUniqueDigits(3));
    }
}
