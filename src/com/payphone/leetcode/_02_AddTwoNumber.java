package com.payphone.leetcode;

public class _02_AddTwoNumber {
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

    /**
     * l1 != null || l2 != null || next != 0任意一种情况成立都需要继续进行for循环。
     * l1 l2不为null，是很明显要进行循环的。因为没有遍历完。
     * 如果l1 l2一样长，且他们的最高位相加后存在进位，即next=1，是需要把这个进位也存进去的!
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
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

    /**
     * 计算时考虑进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 链表按顺序相加。得到的是个位，十位，千位
        ListNode head = new ListNode(-1), tmp = head;
        int next = 0;
        while (l1 != null && l2 != null) {
            int oldSum = l1.val + l2.val + next;
            // 说明无进位
            int newSum = oldSum >= 10 ? Math.abs(oldSum - 10) : oldSum;
            next = oldSum == newSum ? 0 : 1;
            tmp.next = new ListNode(newSum);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = l1 != null ? l1 : l2;
        while (l1 != null) {
            int oldSum = l1.val + next;
            int newSum = oldSum >= 10 ? Math.abs(oldSum - 10) : oldSum;
            next = oldSum == newSum ? 0 : 1;
            tmp.next = new ListNode(newSum);
            l1 = l1.next;
            tmp = tmp.next;
        }

        if (next != 0) tmp.next = new ListNode(next);
        // 链表逆置  头插法
        ListNode out = new ListNode(), cur = out;
        while (head.next != null) {
            ListNode t = head.next;
            head.next = head.next.next;
            cur.next = t;
            cur = cur.next;
        }
        return out.next;
    }

}