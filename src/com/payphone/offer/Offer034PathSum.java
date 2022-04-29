package com.payphone.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer034PathSum {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        helper(root, target, 0, new LinkedList<>());
        return ans;
    }

    private void helper(TreeNode root, int target, int sum, LinkedList<Integer> one) {
        // 会重复检索
        if (root == null) {
            return;
        }
        one.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == sum + root.val) {
                one.add(root.val);
                ans.add(one);
            }
        }
        helper(root.left, target, sum + root.val, one);
        helper(root.right, target, sum + root.val, one);
        one.removeLast();
    }
}
