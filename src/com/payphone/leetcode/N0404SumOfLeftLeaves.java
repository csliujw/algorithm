package com.payphone.leetcode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 左叶子之和。不是最左侧节点的和。使用前序遍历即可
 * 1.判断当前节点是否有左叶子，如果有就把累加上它做叶子的值
 */
public class N0404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] arr = {0};
        helper(root, arr);
        return arr[0];
    }

    private void helper(TreeNode root, int[] arr) {
        if (root == null) return;
        // 判断是否为做叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            arr[0] += root.left.val;
        }
        helper(root.left, arr);
        helper(root.right, arr);
    }

    /**
     * 纯递归做法
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        return helper2(root, 0);
    }

    private int helper2(TreeNode root, int arr) {
        if (root == null) return 0;
        // 判断是否为做叶子节点
        int midVal = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midVal = root.left.val;
        }
        int leftSum = helper2(root.left, arr);
        int rightSum = helper2(root.right, arr);
        return midVal + leftSum + rightSum;
    }

}
