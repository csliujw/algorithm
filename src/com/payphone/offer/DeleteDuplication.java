package com.payphone.offer;

public class DeleteDuplication {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 6, 7, 8, 8, 9, 9, 10, 11, 11, 14, 14, 15, 16, 17, 17, 18, 19};
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 投机取巧
     */
    public ListNode deleteDuplication(ListNode head) {
        int[] map = new int[5000];
        while (head != null) {
            map[head.val] += 1;
            head = head.next;
        }
        ListNode dy = new ListNode(-1);
        ListNode tmp = dy;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                tmp.next = new ListNode(map[i]);
                tmp = tmp.next;
            }

        }
        return dy.next;
    }

}
