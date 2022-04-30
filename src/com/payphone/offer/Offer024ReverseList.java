package com.payphone.offer;


public class Offer024ReverseList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode nexts = head.next;
        // 双指针做法，改变nexts指针的指向，让他指向前一个点。
        while (nexts != null) {
            // 保存next后面的点，防止丢失。
            ListNode c = nexts.next;
            nexts.next = pre;
            pre = nexts;
            nexts = c;
        }
        head.next = null;
        return pre;
    }
}
