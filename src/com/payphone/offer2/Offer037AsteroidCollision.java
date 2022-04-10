package com.payphone.offer2;

import java.util.Collections;
import java.util.Stack;

public class Offer037AsteroidCollision {

    /**
     * - stack 为空，元素 push stack
     * - stack 不为空，看 cur 和 stack.peek 是否满足碰撞的条件，满足则碰撞，不满足则 push stack
     */
    public int[] asteroidCollision(int... asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if (!stack.isEmpty() && as < 0 && stack.peek() == -as) {
                // 小于 as 的出栈后，栈顶的 == -as，则栈顶的出栈。
                stack.pop();
            } else if (as > 0 || stack.isEmpty() || stack.peek() < 0) {
                // 这里是元素入栈的情况。
                // 1.as 大于 0。
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Offer037AsteroidCollision solution = new Offer037AsteroidCollision();
        solution.asteroidCollision(5, 10, -5);
    }
}
