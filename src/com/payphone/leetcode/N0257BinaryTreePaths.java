package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class N0257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, String.valueOf(root.val), ans);
        return ans;
    }

    // 经典的前序遍历，遍历到叶子节点时，将 path 加入 ans
    private void helper(TreeNode root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(path);
        }
        if (root.left != null) {
            helper(root.left, path + "->" + root.left.val, ans);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + root.right.val, ans);
        }
    }
}
