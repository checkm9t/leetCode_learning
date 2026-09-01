package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 划分字母区间
// leetcode 45
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 记录每一个字符最后出现的位置
            last[s.charAt(i) - 'a'] = i;
        }

        // left 用来记录上一个区间的末尾位置
        int left = -1;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 更新最远的位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // 如果到达了最远的位置，进行切割
            if (i == end) {
                res.add(i - left);
                left = i;
            }
        }
        return res;
    }
}
