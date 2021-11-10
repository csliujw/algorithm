package com.payphone.leetcode;

/**
 * 移除指定值的节点
 */
public class _203_removeElements {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 循环做法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return dummy.next;
    }

    // 递归做法

    /**
     * 链表为空 停止递归，
     * 不为空判断是否满足删除条件
     * 满足则删除后继续递归
     * 不满足则元素后移继续递归
     */
    public ListNode remove(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        return removeElements2(dummy, val);
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null || head.next == null) return head;
        if (head.next.val == val) {
            //删除
            head.next = head.next.next;
        } else {
            // 后移
            head = head.next;
        }
        return removeElements2(head.next, val);
    }

}
