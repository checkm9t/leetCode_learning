package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

// 不同字符的最小子序列
// leetcode 1081
public class _SmallestSubsequence {


    public String smallestSubsequence(String s) {

        // 表示当前字符在之后还会出现多少次
        int[] cnt = new int[26];

        // 用于去重
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 一定要先减
            cnt[c - 'a']--;

            // 因为是单调栈
            // 如果已经有了，不用走淘汰，或者添加逻辑
            // 因为已经是递增了，淘汰没有意义
            if (set.contains(c)) {
                continue;
            }

            // 如果当前字符的字典序小于栈顶元素并且后面还有这个字符
            // 则弹出
            while (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                if (c < last && cnt[last - 'a'] > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    set.remove(last);
                } else {
                    break;
                }
            }

            sb.append(c);
            set.add(c);
        }

        return sb.toString();

    }
}
