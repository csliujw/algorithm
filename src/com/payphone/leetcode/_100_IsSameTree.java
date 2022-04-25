package com.payphone.leetcode;

public class _100_IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return hepler(p, q);
    }

    private boolean hepler(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        // 一定有点不为空。如果有一个不为空，|| 都不为空 且 val 不等
        if ((q == null || p == null) || (q.val != p.val)) return false;
        return hepler(p.left, q.left) && hepler(p.right, q.right);
    }
}
