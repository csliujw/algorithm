package com.payphone.leetcode;

/**
 * leetcode给的说明太垃圾了。
 * 实际意思是，给你节点node，把这个节点删除了。
 */
public class _237_DeleteNode {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
