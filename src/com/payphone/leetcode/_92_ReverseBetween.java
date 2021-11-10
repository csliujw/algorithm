package com.payphone.leetcode;

/**
 * 翻转链表
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class _92_ReverseBetween {

    // 需要画图才好理解。指针的操作比较复杂
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        for (int i = 0; i < left - 1; i++) {
            a = a.next;
        }
        ListNode b = a.next;
        ListNode c = b.next;
        // 三个节点，需要做2次翻转
        for (int i = 0; i < right - left; i++) {
            ListNode d = c.next;
            c.next = b;
            b = c;
            c = d;
        }
        // 画图理解
        a.next.next = c;
        a.next = b;
        return dummy.next;
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
