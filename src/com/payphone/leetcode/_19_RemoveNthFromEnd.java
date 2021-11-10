package com.payphone.leetcode;

public class _19_RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 双指针，定义虚拟头结点 pre next， next先走n步。然后两个指针同时移动，next.next为null时，pre.next就是
    // 要删除的结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre, next;
        pre = next = dummy;
        for (int i = 0; i < n; i++) {
            next = next.next;
        }
        while (next.next != null) {
            pre = pre.next;
            next = next.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
