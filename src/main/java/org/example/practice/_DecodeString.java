package org.example.practice;

import java.util.Stack;

public class _DecodeString {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder tmpNum = new StringBuilder();
        StringBuilder tmpStr = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (!tmpNum.isEmpty()) {
                    // 有栈对齐的问题num不为空，str即使为空字符串也要加进去
                    numStack.push(Integer.valueOf(tmpNum.toString()));
                    strStack.push(tmpStr.toString());

                    tmpNum.setLength(0);
                    tmpStr.setLength(0);
                }
            } else if (c == ']') {
                StringBuilder str = new StringBuilder();
                if (!strStack.isEmpty()) {
                    str.append(strStack.pop());
                }

                int num = 0;
                if (!numStack.isEmpty()) {
                    num = numStack.pop();
                }
                for (int i = 0; i < num; i++) {
                    str.append(tmpStr.toString());
                }

                // 这里不要入栈，而是给tmpStr
                tmpStr = str;

            } else {
                if (c >= '0' && c <= '9') {
                    tmpNum.append(c);
                } else {
                    tmpStr.append(c);
                }
            }
        }
        return tmpStr.toString();
    }
}
