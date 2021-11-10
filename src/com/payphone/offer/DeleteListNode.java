package com.payphone.offer;

/**
 * 1.O(1)时间复杂度删除链表节点。
 * 2.删除链表指定节点。
 */
public class DeleteListNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 1.O(1)时间复杂度删除链表节点。
    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 2.删除链表指定节点。
    public ListNode deleteNode2(ListNode head, int val) {
        ListNode dynamic = new ListNode(-1);
        dynamic.next = head;
        ListNode tmp = dynamic;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
                return dynamic.next;
            }
            tmp = tmp.next;
        }
        return dynamic.next;
    }
}
