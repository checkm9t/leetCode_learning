package org.example.examination.bytedance;

import java.util.Stack;

public class SimplifiyPath {


    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String p : parts) {
            if (p.isEmpty() || p.equals(".")) {
                continue;
            } else if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        // 需要判断，在stack里没有数的时候应该返回"/" 而不是空字符串
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        String[] resArr = stack.toArray(new String[0]);
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/").append(resArr[i]);
        }

        return sb.toString();
    }
}
