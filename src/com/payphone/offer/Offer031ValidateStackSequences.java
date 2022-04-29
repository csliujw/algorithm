package com.payphone.offer;

import org.junit.Test;

import java.util.Stack;

public class Offer031ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.size() == 0;
    }

    @Test
    public void f1() {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {4,3,5,1,2};
        System.out.println(validateStackSequences(s1, s2));
    }
}
