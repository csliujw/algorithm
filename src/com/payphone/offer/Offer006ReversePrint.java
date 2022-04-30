package com.payphone.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Offer006ReversePrint {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> list = new Stack<>();
        while (head != null) {
            list.push(head.val);
            head = head.next;
        }
        int[] retVal = new int[list.size()];
        int i = -1;
        while (!list.isEmpty()) {
            retVal[++i] = list.pop();
        }
        return retVal;
    }
}
