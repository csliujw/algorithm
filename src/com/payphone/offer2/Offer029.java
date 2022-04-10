package com.payphone.offer2;

public class Offer029 {
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }


    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node cur = new Node(insertVal);
            cur.next = cur;
            return cur;
        }
        if (head == head.next) {
            Node cur = new Node(insertVal, head);
            head.next = cur;
            return head;
        }
        /*
        - 当 min <= inertVal <= max 时，满足 cur <= insertVal <= cur.next 即可插入
        - 当 inertVal > max 时，插入到 max 的后面即可
        - 当 insertVal < min 时，插入到 max 的后面即可
        */
        Node cur = head;
        Node next = head.next;
        Node biggest = head;

        while (!(cur.val <= insertVal && next.val >= insertVal) && next != head) {
            cur = next;
            next = next.next;
            biggest = cur.val >= biggest.val ? cur : biggest;
        }
        if (cur.val <= insertVal && next.val >= insertVal) {
            cur.next = new Node(insertVal, next);
        } else {
            biggest.next = new Node(insertVal, biggest.next);
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(4);
        node.next.next = new Node(1);
        node.next.next.next = node;
        Offer029 offer029 = new Offer029();
        offer029.insert(node, 2);
    }

}
