package com.payphone.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_LevelOrder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelCount = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < curLevelCount; i++) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (int j = 0; j < cur.children.size(); j++) {
                    queue.add(cur.children.get(j));
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
