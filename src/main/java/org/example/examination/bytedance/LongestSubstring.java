package org.example.examination.bytedance;

// 至少有 K 个重复字符的最长子串
// leetcode 395
public class LongestSubstring {


    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        // 统计 [l,r] 字符频次
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        // 找分割点：频次<k的字符
        int split = -1;
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (cnt[c - 'a'] < k) {
                split = i;
                break;
            }
        }
        // 没有分割点，整段合法
        if (split == -1){
            return r - l + 1;
        }

        // 分割成左右两段递归
        int left = dfs(s, l, split - 1, k);
        int right = dfs(s, split + 1, r, k);
        return Math.max(left, right);
    }
}
