package org.example.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                // 当c为')'时，不会为空
                stack.pop();
                if (stack.isEmpty()) {
                    // 如果为空，则成为新的边界，不计算
                    stack.push(i);
                } else {
                    //如果不为空，则代表出现了一个新的组合，可以计算一次
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}
