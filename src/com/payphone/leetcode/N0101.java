package com.payphone.leetcode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 */
public class N0101 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;

        boolean left = helper(r1.left, r2.right);
        boolean right = helper(r1.right, r2.left);
        return left && right;
    }
}
