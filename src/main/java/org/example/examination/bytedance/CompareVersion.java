package org.example.examination.bytedance;

// 比较版本号
// leetcode 165
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        int i = 0;
        int j = 0;

        // 注意：这里应该是或而不是与
        while (i < n || j < m) {

            StringBuilder numstr1 = new StringBuilder();
            while (i < n && version1.charAt(i) != '.') {
                numstr1.append(version1.charAt(i));
                i++;
            }
            i++;

            StringBuilder numstr2 = new StringBuilder();
            while (j < m && version2.charAt(j) != '.') {
                numstr2.append(version2.charAt(j));
                j++;
            }
            j++;


            // 注意：这个三目运算符很重要，否则空字符串解析会报错
            int num1 = numstr1.isEmpty() ? 0 : Integer.valueOf(numstr1.toString());
            int num2 = numstr2.isEmpty() ? 0 : Integer.valueOf(numstr2.toString());

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
