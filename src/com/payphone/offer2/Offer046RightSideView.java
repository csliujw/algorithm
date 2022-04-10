package com.payphone.offer2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer046RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.remove();
                System.out.println(curNode.val);
                if (i == size - 1) {
                    ans.add(curNode.val);
                    System.out.println(curNode.val);
                }
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
        }
        return ans;
    }
}
