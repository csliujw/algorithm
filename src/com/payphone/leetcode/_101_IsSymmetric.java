package com.payphone.leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int[] curlevel = new int[queue.size()];
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
                curlevel[i] = poll == null ? -10086 : poll.val;
            }
            System.out.println(Arrays.toString(curlevel));
            for (int i = 0, j = curlevel.length - 1; i < j; i++) {
                if (curlevel[i] != curlevel[j]) return false;
            }
        }
        return true;
    }

    private boolean helper2(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) return true;
        if ((p1 == null && p2 != null) || (p1 != null && p2 == null)) return false;
        if (p1.val != p2.val) return false;
        return helper2(p1.left, p2.right) && helper2(p1.right, p2.left);
    }

    // 每次入队元素两次，每次也拿两个，比较它们的值是否 same
    private boolean helper3(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root1);
        q.offer(root2);
        while (!q.isEmpty()) {
            root1 = q.poll();
            root2 = q.poll();
            if (root1 == null && null == root2) continue;
            if ((root1 == null || root2 == null) || (root1.val != root2.val)) return false;
            q.offer(root1.left);
            q.offer(root2.right);

            q.offer(root1.right);
            q.offer(root2.left);
        }
        return true;
    }

}
