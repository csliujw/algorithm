package com.payphone.offer;


import java.util.LinkedList;

public class Codec {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        StringBuffer treeStr = new StringBuffer("");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeFirst();
            if (treeNode.left != null) {
                queue.addLast(treeNode.left);
                treeStr.append(",").append(treeNode.left.val);
            } else {
                treeStr.append(",#");
            }
            if (treeNode.right != null) {
                queue.addLast(treeNode.right);
                treeStr.append(",").append(treeNode.right.val);
            } else {
                treeStr.append(",#");
            }
        }
        return treeStr.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split.length == 0) return null;
        else if (split.length == 1) return new TreeNode(Integer.parseInt(split[0]));
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(split[index++]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (index < split.length && !queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (!"#".equals(split[index])) {
                cur.left = new TreeNode(Integer.parseInt(split[index]));
                queue.addLast(cur.left);
            }
            index++;
            if (!"#".equals(split[index])) {
                cur.right = new TreeNode(Integer.parseInt(split[index]));
                queue.addLast(cur.right);
            }
            index++;
        }
        return root;
    }
}