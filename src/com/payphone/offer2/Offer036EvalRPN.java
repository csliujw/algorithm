package com.payphone.offer2;

import java.util.Stack;

/**
 * 后缀表达式
 */
public class Offer036EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                case "-":
                case "*":
                case "/":
                    Integer ele1 = stack.pop();
                    Integer ele2 = stack.pop();
                    int result = calculate(ele1, ele2, tokens[i]);
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    private int calculate(Integer ele1, Integer ele2, String express) {
        switch (express) {
            case "+":
                return ele1 + ele2;
            case "-":
                return ele2 + ele1;
            case "*":
                return ele2 * ele1;
            case "/":
                return ele2 / ele1;
        }
        return -1;
    }
}
