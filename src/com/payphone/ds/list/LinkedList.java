package com.payphone.ds.list;

// 这个链表的实现 无虚拟头节点。
public class LinkedList<E> {
    private int size;
    // 虚拟头节点
    private Node dummy;

    public LinkedList() {
        dummy = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        /**
         Node node = new Node(e);
         node.next = head;
         head = node;
         **/
        add(0, e);
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > this.size) throw new IllegalArgumentException("index should xx");
        // 如果是索引0插入的话。

        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /**
         * Node node = new Node(element);
         * node.next = prev.next;
         * prev.next = node;
         **/
        prev.next = new Node(element, prev.next);
        size++;
    }

    public void print() {
        Node tmp = dummy;
        while (tmp != null) {
            System.out.format("%d\t", tmp.element);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.add(2, 5);
        list.add(0, -1);
        list.print();
    }

    private class Node {
        public E element;
        public Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }
}
