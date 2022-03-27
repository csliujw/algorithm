package com.payphone.ds.bst;

/**
 * 此版本为递归版本
 * @param <E>
 */
public class BSTDemo<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;
    }

    private Node root; // 根节点
    private int size;

    public BSTDemo() {
        this.root = null;
        this.size = 0;
    }

    public boolean insert() {
        return false;
    }

    public E search() {
        return null;
    }
}
