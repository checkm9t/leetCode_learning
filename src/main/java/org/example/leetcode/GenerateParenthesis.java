package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// leetcode 22
// 括号生成
public class GenerateParenthesis {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        dfs(n, 0, 0, new StringBuilder());

        return res;

    }

    public void dfs(int n, int left, int right, StringBuilder tmp) {
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            res.add(tmp.toString());
            return;
        }

        // 加左括号
        if (left < n) {
            tmp.append('(');
            dfs(n, left + 1, right, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }

        // 加右括号
        if(right<left){
            tmp.append(')');
            dfs(n, left, right + 1, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }

    }

}
