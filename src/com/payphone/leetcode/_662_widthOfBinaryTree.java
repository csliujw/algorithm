package com.payphone.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大宽度。
 * 用层序遍历来做。
 */
public class _662_widthOfBinaryTree {

    public int widthOfBinaryTree2(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        //
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode cur = queue.poll();
            if (cur.node != null) {
                // 记录节点所在的位置。
                queue.add(new AnnotatedNode(cur.node.left, cur.depth + 1, cur.pos * 2));
                queue.add(new AnnotatedNode(cur.node.right, cur.depth + 1, cur.pos * 2 + 1));
                if (curDepth != cur.depth) {
                    curDepth = cur.depth;
                    left = cur.pos;
                }
                ans = Math.max(ans, cur.pos - left + 1);
            }
        }
        return ans;
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
