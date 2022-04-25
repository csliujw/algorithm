package com.payphone.offer;

import java.util.HashMap;

public class Offer052GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while (headA != null) {
            map.put(headA, true);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.getOrDefault(headB, false)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
