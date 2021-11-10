package com.payphone.leetcode;

import java.util.ArrayList;

/*
  回文链表
 */
public class _234_isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int start = 0, end = list.size() - 1; start <= end; start++, end--) {
            if (list.get(start) != list.get(end)) return false;
        }
        return true;
    }

    class ListNode {
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
}
