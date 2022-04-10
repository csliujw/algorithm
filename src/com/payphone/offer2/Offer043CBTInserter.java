package com.payphone.offer2;

import java.util.LinkedList;
import java.util.Queue;

public class Offer043CBTInserter {
    static class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> queue;

        // root 是一棵树
        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            // 把 root 中左右子树不全的加入队列
            Queue<TreeNode> tmp = new LinkedList<>();
            tmp.add(root);
            while (!tmp.isEmpty()) {
                TreeNode poll = tmp.poll();
                if (poll.left != null) tmp.add(poll.left);
                if (poll.right != null) tmp.add(poll.right);
                if (poll.left == null || poll.right == null) queue.add(poll);
            }
        }

        public int insert(int v) {
            TreeNode curNode = new TreeNode(v);
            TreeNode peek = queue.peek();
            if (peek.left == null) {
                peek.left = curNode;
            } else if (peek.right == null) {
                peek.right = curNode;
                queue.remove();
            }
            queue.add(curNode);
            return peek.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
