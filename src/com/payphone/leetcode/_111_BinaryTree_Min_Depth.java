package com.payphone.leetcode;

import com.payphone.leetcode.structure.TreeNode;

public class _111_BinaryTree_Min_Depth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return min(root);
    }

    /**
     * 考虑的边界条件比较多
     * ① 单分支结构的二叉树
     * ② 无左右子树的直接返回一（因为 return 过 Integer.MAX_VALUE）
     */
    public int min(TreeNode root) {
        // 单分支 binary Tree 的情况
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // 因为 binary tree 为 null 时返回的 MAX_VALUE，
        // 所以如果左右子树为空 返回 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = min(root.left);
        int right = min(root.right);
        return Math.min(left, right) + 1;
    }
}
