package org.example.leetcode;

public class Multiply {


    public String multiply(String num1, String num2) {
        // 边界：任意一个为0，直接返回"0"
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        // m位 * n位，结果最多 m+n 位
        int[] arr = new int[m + n];

        // 从个位开始遍历（逆序）
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int product = a * b;
                // product 叠加到对应位置
                int sum = product + arr[i + j + 1];

                // 理解这个下标：i+j+1
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }

        // 拼接结果，跳过前导0
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            // sb为空的时候，遇到0就跳过
            if (!(sb.length() == 0 && val == 0)) {
                sb.append(val);
            }
        }
        return sb.toString();
    }
}
