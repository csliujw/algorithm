package com.payphone.offer2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer044LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            int curLevelMax = Integer.MIN_VALUE;
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.remove();
                curLevelMax = Math.max(curLevelMax, curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            ans.add(curLevelMax);
        }
        return ans;
    }
}
