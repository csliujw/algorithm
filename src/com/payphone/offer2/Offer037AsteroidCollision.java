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

    // 行星碰撞
    public int[] asteroidCollision2(int... asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            // 栈顶元素是否需要弹出
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            // as 元素是否需要消除，as < 0 这个条件是为了避免误判
            if (!stack.isEmpty() && stack.peek() == -as && as < 0) {
                stack.pop();
            } else if (as > 0 || stack.isEmpty() || stack.peek() < 0) {
                // as 不用消除，需要添加到 stack 的情况 && 正常添加元素的情况。
                // as > 0 属于普通情况，需要入 stack
                // stack.isEmpty 属于第一次加元素和as让栈中的所有元素都出栈
                // stack.peek 属于 as 和 peek 同号的情况
                stack.push(as);
            }
        }
        int[]ans = new int[stack.size()];
        for (int i = 0; i <ans.length ; i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Offer037AsteroidCollision solution = new Offer037AsteroidCollision();
        solution.asteroidCollision(5, 10, -5);
    }
}
