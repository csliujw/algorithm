package com.payphone.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_LevelOrderBottom {
    // 底到头遍历。后进先出。头插法
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
                curList.add(poll.val);
            }
            ans.addFirst(curList);
        }
        return ans;
    }
}
