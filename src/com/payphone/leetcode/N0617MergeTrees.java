package com.payphone.leetcode;


public class N0617MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    /**
     * 结果建在 root1 上
     * root1 为 null 则 root2 作为 root1 根节点的子树
     * root2 为 null，则 root1 作为 root1 根节点的子树
     * 都不会空，则 root1.val = root1.val+root2.val;
     * --- 再递归合并 root1 和 root2 的左子树。合并的结果作为 root1 的左子树
     * --- 合并右子树的方式同上
     */
    private TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        // 合并左右子树
        root1.val += root2.val;
        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);
        return root1;
    }
}
