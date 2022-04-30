package com.payphone.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 头节点是最低位。一般加法是从低向高位加。所以元素逐一相加保持进位即可。
 * 返回的链表，头节点也要是最低位。所以可以采用尾插法插入链表。
 */
public class N0002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addLocal = 0;
        ListNode ans = new ListNode(1);
        ListNode cur = ans;
        while (l1 != null || l2 != null) {
            // 拿到每个链表的元素
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 构建节点进行尾插。
            cur.next = new ListNode((n1 + n2 + addLocal) % 10);
            cur = cur.next;
            // 检查是否有进位
            addLocal = (n1 + n2 + addLocal > 9 ? 1 : 0);
            // 链表指针后移。
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        // 检查最高位是否存在进位
        if (addLocal == 1) cur.next = new ListNode(1);
        return ans.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), cur = head;
        int next = 0;
        while (l1 != null || l2 != null || next != 0) {
            if (l1 != null) {
                next += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                next += l2.val;
                l2 = l2.next;
            }
            cur.next = cur = new ListNode(next % 10);
            next /= 10;
        }
        return head.next;
    }
}
