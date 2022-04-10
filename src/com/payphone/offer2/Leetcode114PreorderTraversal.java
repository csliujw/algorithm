package com.payphone.offer2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode114PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            dfs(root.left, nodes);
            dfs(root.right, nodes);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return nodes;
    }


}
