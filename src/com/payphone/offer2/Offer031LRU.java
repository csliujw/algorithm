package com.payphone.offer2;

import java.util.HashMap;
import java.util.Map;

public class Offer031LRU {
    // 双向链表节点
    class Node {
        int val;
        int key;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    class LRUCache {
        private Map<Integer, Node> map;
        private Node head;//双链表头节点
        private Node tail;//双链表，尾节点
        private int capacity;
        private int curSize;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.curSize = 0;
            map = new HashMap<>();
            head = new Node(-1, -1, null, null);
            tail = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                // 存在，则得到值，并把节点移动到末尾。
                moveToTail(node);
                return node.val;
            }
            return -1;
        }

        private void moveToTail(Node node) {
            remove(node);
            addNode(node);
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                // 存在，则找到节点然后移动,size 不变
                node.val = value;
                map.put(key, node);
                moveToTail(node);
            } else { // 不存在
                Node waitInsert = new Node(key, value, null, null);
                map.put(key, waitInsert);
                if (curSize < capacity) { // 没有超过容量，直接添加
                    addNode(waitInsert);
                    curSize++;
                } else { // 超过容量，先移除，再添加
                    map.remove(head.next.key);
                    remove(head.next); // 移除头部的元素
                    addNode(waitInsert);
                }
            }
        }

        private void remove(Node node) {
            // 移除双链表中的节点
            Node head = node.pre;
            if (node.next == null) {
                // 说明 node 是尾部节点
                head.next = null;
                tail = head;
            } else {
                node.next.pre = head;
                head.next = node.next;
            }
        }

        private void addNode(Node insert) {
            insert.pre = tail;
            insert.next = null;
            tail.next = insert;
            tail = insert;
        }
    }

    public static void main(String[] args) {
        Offer031LRU offer031LRU = new Offer031LRU();
        LRUCache lru = offer031LRU.new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.get(2);
        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }
}
