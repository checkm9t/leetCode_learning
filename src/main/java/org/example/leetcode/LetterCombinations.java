package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> res;
    public Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        res = new ArrayList<>();
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    public void dfs(String digits, StringBuilder str, int index) {
        if (index == digits.length()) {
            res.add(str.toString());
            return;
        }

        String tmp = map.get(digits.charAt(index));
        for (char d : tmp.toCharArray()) {
            str.append(d);
            dfs(digits, str, index + 1);
            str.deleteCharAt(str.length() - 1);
        }

    }
}
