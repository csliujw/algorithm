package com.payphone.leetcode;

import java.util.*;

public class _103_ZigzagLevelOrder {

    // 正常的层序遍历，不过插入元素时候需要注意顺序。

    /**
     * 先头插，在尾插
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isHeadInsert = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> cur = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (isHeadInsert) {
                    cur.addFirst(poll.val);
                } else {
                    cur.addLast(poll.val);
                }
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            isHeadInsert = !isHeadInsert;
            ans.add(cur);
        }
        return ans;
    }
}
