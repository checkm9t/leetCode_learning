package org.example.examination;

public class KMP {

    class Solution {
        public int strStr(String haystack, String needle) {

            int n = haystack.length();
            int m = needle.length();

            haystack = " " + haystack;
            needle = " " + needle;

            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();

            // next[i]
            int[] next = new int[m + 1];

            // i 表示后缀，第一个匹配了，下一个不匹配的话，肯定还是归零
            // j 表示 pattern 已经匹配了多少个字符
            for (int i = 2, j = 0; i < m; i++) {

                // 递归寻找能够匹配的最小的前缀
                // 如果递归到0，就停止
                while (j > 0 && p[i] != p[j + 1]) {
                    // next[j] 一定已经被填充过
                    j = next[j];
                }

                if (p[i] == p[j + 1]) {
                    j++;
                }

                // 每一个i都有一个回退值，必定设置
                next[i] = j;
            }

            for (int i = 1, j = 0; i < n; i++) {

                // 先找到最多匹配的后缀
                while (j > 0 && s[i] != p[j + 1]) {
                    j = next[j];
                }

                // 然后开始匹配新的后缀
                if (s[i] == p[j + 1]) {
                    j++;
                }

                // 若果匹配数量到头了，就找到了
                if (j == m) {
                    return i - m;
                }

            }

            return -1;

        }
    }

}
