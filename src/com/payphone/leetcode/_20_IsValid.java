package com.payphone.leetcode;

import java.util.Stack;

/**
 * 有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _20_IsValid {
    /**
     * 典型的数据结构问题，用stack
     */
    Stack<Character> stack = new Stack<Character>();

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 左括号就入stack
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                // 不是左括号就看有无匹配的右括号。 有则继续遍历，无则返回false
                if (!stack.isEmpty() && Math.abs(s.charAt(i) - stack.pop()) <= 2) {
                    continue;
                } else return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
