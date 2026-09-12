package org.example.examination.bytedance;

import java.util.Arrays;

public class MaxLessN {

    public static String maxLessN(String[] digits, int n) {
        String s = String.valueOf(n);
        int k = s.length();

        // dp[i][0]：前 i 位已经严格小于 n 的最大结果
        // dp[i][1]：前 i 位恰好等于 n 的结果
        String[][] dp = new String[k + 1][2];

        // 初始状态：空前缀与 n 的空前缀相等
        dp[0][0] = null;
        dp[0][1] = "";

        // 避免修改调用者传入的数组
        Arrays.sort(digits, (a, b) ->
                Integer.compare(Integer.parseInt(b), Integer.parseInt(a))
        );

        String maxDigit = digits[0];

        for (int i = 1; i <= k; i++) {
            char limit = s.charAt(i - 1);

            dp[i][0] = null;
            dp[i][1] = null;

            /*
             * 情况一：上一位仍然和 n 相等
             */
            if (dp[i - 1][1] != null) {
                for (String digit : digits) {
                    char current = digit.charAt(0);

                    if (current == limit) {
                        // 继续保持相等
                        dp[i][1] = dp[i - 1][1] + digit;
                    } else if (current < limit) {
                        // 当前位第一次变小
                        dp[i][0] = dp[i - 1][1] + digit;
                        break;
                    }
                }
            }

            /*
             * 情况二：上一位已经小于 n
             * 后面直接补允许使用的最大数字
             */
            if (dp[i][0] == null) {
                if (dp[i - 1][0] != null) {
                    dp[i][0] = dp[i - 1][0] + maxDigit;
                } else if (i == 1) {
                    /*
                     * 无法构造和 n 等长的数，尝试构造少一位的数。
                     * 空字符串相当于先不占用第一位。
                     */
                    dp[i][0] = "";
                }
            }
        }

        String result = dp[k][0];

        if (result == null || result.isEmpty()) {
            return "-1";
        }

        return result;
    }

    public static void main(String[] args) {
        String[] digits1 = {"2", "4", "9"};
        System.out.println(maxLessN(digits1, 23121));  // 22999

        String[] digits2 = {"1", "2", "3"};
        System.out.println(maxLessN(digits2, 231));    // 223

        String[] digits3 = {"1"};
        System.out.println(maxLessN(digits3, 10));     // 1

        String[] digits4 = {"6"};
        System.out.println(maxLessN(digits4, 5));      // -1

        // 新增反例测试
        String[] test5 = {"1","2"};
        System.out.println(maxLessN(test5, 100)); //预期22
        String[] test6 = {"2","5"};
        System.out.println(maxLessN(test6, 21));  //预期5
        String[] test7 = {"3"};
        System.out.println(maxLessN(test7, 2));   //预期-1
    }
}