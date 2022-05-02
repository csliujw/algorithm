package com.payphone.offer;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 后序遍历
 */
public class Offer055IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return -1 != helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        // left,right == -1 是当左右子树不是叶子节点时，判断是否 AVL
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
