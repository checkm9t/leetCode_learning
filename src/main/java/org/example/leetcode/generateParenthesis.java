package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        dfs(n, 0, 0, new StringBuilder());

        return res;

    }

    public void dfs(int n, int left, int right, StringBuilder tmp) {
        int l = tmp.length();
        if (right > left) {
            return;
        }
        if (l >= n * 2) {
            if (left == right) {
                res.add(tmp.toString());
            }
            return;
        }

        tmp.append('(');
        dfs(n, left + 1, right, tmp);
        tmp.deleteCharAt(tmp.length() - 1);

        tmp.append(')');
        dfs(n, left, right + 1, tmp);
        tmp.deleteCharAt(tmp.length() - 1);

    }

}
