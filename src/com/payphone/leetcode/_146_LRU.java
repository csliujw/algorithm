package com.payphone.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/*
请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
    - LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
    - int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    - void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
    - 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class _146_LRU {
    int capacity;
    // 存 key
    LinkedList<Integer> saveNodeList = new LinkedList<>();
    // 存 key 中对应的 value
    HashMap<Integer, Integer> findValue = new HashMap<>();

    // 初始化缓存大小
    public _146_LRU(int capacity) {
        this.capacity = capacity;
    }

    // 查找缓存中的元素 用 hashMap
    public int get(int key) {
        return -1;
    }

    // 超过缓存大小的话就移除。用双链表存储数据.
    // key 存在的话就修改 value。
    public void put(int key, int value) {
    }

    static class Node {
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        _146_LRU lru = new _146_LRU(2);
        lru.get(2);
        lru.put(2, 6);
        lru.get(1);
        lru.put(1, 5);
        lru.put(1, 2);
        lru.get(1);
        lru.get(2);
    }
}
