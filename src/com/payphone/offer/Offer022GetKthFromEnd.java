package com.payphone.offer;

public class Offer022GetKthFromEnd {

    // 不用判断边界条件也可以过
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 双指针 pre next
        // next先走k步。 然后pre和next同时走。当next.next == null 时 说明走到头了。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode next = dummy;
        for (int i = 0; i < k; i++) {
            next = next.next;
        }
        while (next.next != null) {
            pre = pre.next;
            next = next.next;
        }
        return pre.next;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        // 双指针 pre next
        // next先走k步。 然后pre和next同时走。当next.next == null 时 说明走到头了。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre, next;
        pre = next = dummy;
        for (int i = 0; i < k; i++) {
            if (next == null) return head;
            next = next.next;
        }
        if (next == null || next.next == null) return head;
        while (next.next != null) {
            pre = pre.next;
            next = next.next;
        }
        return next.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
