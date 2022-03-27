package com.payphone.offer3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class offer23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 法一：hashmap。判断。
        if(headA == null || headB == null) return null;
        HashMap<ListNode,Object> map = new HashMap<>();
        while(headA!=null){
            map.put(headA,new Object());
            headA = headA.next;
        }
        while(headB!=null){
            if(map.containsKey(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        // 法一：hashmap。判断。
        if(headA == null || headB == null) return null;
        LinkedList<ListNode> s1 = new LinkedList<>();
        LinkedList<ListNode> s2 = new LinkedList<>();

        while(headA!=null){
            s1.push(headA);
            headA = headA.next;
        }
        while(headB!=null){
            s2.push(headB);
            headB = headB.next;
        }

        while(!s1.isEmpty() && !s2.isEmpty()){
            ListNode t1 = s1.pop();
            ListNode t2 = s2.pop();
            if(t1==t2) return t1;
        }
        return null;
    }
}
