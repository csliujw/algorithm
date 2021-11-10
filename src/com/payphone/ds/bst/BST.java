package com.payphone.ds.bst;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    // 为空时，才创建。这样递归条件就少了。

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) return true;
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.left, e);
        }
    }

    /**
     * 二叉树的前序遍历
     */
    public void preOrder(Node node) {
        if (node == null) return;
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 二叉树的中序遍历
     */
    public void midOrder(Node node) {
        if (node != null) {
            midOrder(node.left);
            System.out.println(node.e);
            midOrder(node.right);
        }
    }

    /**
     * 二叉树的中序遍历
     */
    public void afterOrder(Node node) {
        if (node != null) {
            afterOrder(node.left);
            afterOrder(node.right);
            System.out.println(node.e);
        }
    }


    /**
     * private void add(Node node, E e) {
     * if (e.equals(node.e)) return;
     * else if (e.compareTo(node.e) < 0 && node.left == null) {
     * node.left = new Node(e);
     * size++;
     * return;
     * } else if (e.compareTo(node.e) > 0 && node.right == null) {
     * node.right = new Node(e);
     * size++;
     * return;
     * }
     * if (e.compareTo(node.e) < 0) add(node.left, e);
     * if (e.compareTo(node.e) > 0) add(node.right, e);
     * }
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 36, 5, 8, 9, 3, 21, 58};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.midOrder(bst.root);
    }
}
