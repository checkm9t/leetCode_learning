package org.example.leetcode;

// 矩阵置零
// leetcode 73
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            // 先判断第一列是不是0
            if (matrix[i][0] == 0) {
                col0 = 0;
            }

            // j从1开始，因为如果j=0时，就刚好记录了这一行为0，不需要标记了，不需要处理
            // 如果j从0开始的话，会影响matrix[0][0]的结果判断
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 因为第0行必须留到最后处理，所以是倒序
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后处理第0列
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        return;
    }
}
