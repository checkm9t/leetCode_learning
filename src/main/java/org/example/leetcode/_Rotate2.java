package org.example.leetcode;

// 旋转图像
// leetcode 48
public class _Rotate2 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // i是n/2，那么j就是(n+1)/2
        //
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
