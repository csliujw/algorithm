package com.payphone.offer2;

public class Offer049SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) return 0;
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) return path;
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
