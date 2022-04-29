package com.payphone.offer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class _09_CQueue {
    public static void main(String[] args) {
        _09_CQueue que = new _09_CQueue();
        que.appendTail(1);
        que.appendTail(2);
        que.appendTail(3);
        que.appendTail(4);
        System.out.println(que.deleteHead());
        System.out.println(que.deleteHead());
        System.out.println(que.deleteHead());
        System.out.println(que.deleteHead());
    }

    public _09_CQueue() {

    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // s1 中入
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
