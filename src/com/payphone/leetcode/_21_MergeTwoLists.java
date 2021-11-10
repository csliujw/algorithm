package com.payphone.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class _21_MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            tail.next = l1.val < l2.val ? l1 : l2;
            tail = tail.next;
            if (l1.val < l2.val)
                l1 = l1.next;
            else l2 = l2.next;
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        return dummy.next;
    }


    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            tail.next = l1.val < l2.val ? l1 : l2;
            tail = tail.next;
            if (l1.val < l2.val) l1 = l1.next;
            else l2 = l2.next;
        }
        tail.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
