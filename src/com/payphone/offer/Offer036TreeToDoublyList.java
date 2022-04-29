package com.payphone.offer;

public class Offer036TreeToDoublyList {
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        head = root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return root;
    }

    private void dfs(Node root) {
        if(root==null) return;
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }
        System.out.println(root.val);
        dfs(root.right);
        pre = root;
    }
}
