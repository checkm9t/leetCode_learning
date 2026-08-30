package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 有效的括号
// leetcode 20
public class IsValid {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        // 注意：需要判断栈里是否有剩余的括号未匹配
        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
