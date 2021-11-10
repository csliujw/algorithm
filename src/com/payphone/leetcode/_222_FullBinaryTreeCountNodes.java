package com.payphone.leetcode;

import com.payphone.leetcode.structure.TreeNode;

public class _222_FullBinaryTreeCountNodes {
    public int countNodes(TreeNode root) {
        // 左子树 + 右子树 + 自己 = 节点数目
        return count(root);
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        return left + right + 1;
    }
}
