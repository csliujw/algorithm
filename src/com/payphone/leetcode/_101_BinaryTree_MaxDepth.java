package com.payphone.leetcode;


import com.payphone.leetcode.structure.TreeNode;

/**
 * - 本质上就是求树的最大深度
 * 递归
 * 当前节点的最大深度 = Max(left,right) + 1
 * - 先求左右子树的结点数后选择其中的max
 * - 边界条件，节点为 null 返回0
 */
public class _101_BinaryTree_MaxDepth {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode root) {
        // 边界条件
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
        // 继续递归
    }
}
