package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParenthesis {
    List<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return list;
    }

    private void dfs(int n, int left, int right, String path) {
        if (left == n && right == n) list.add(path);
        else {
            if (left < n) dfs(n, left + 1, right, path + "(");
            if (right < n && left > right) dfs(n, left, right + 1, path + ")");
        }
    }
}
