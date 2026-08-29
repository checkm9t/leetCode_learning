package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
// leetcode 54
public class SpiralOrder {


    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int high = 0;
        int low = n - 1;

        List<Integer> res = new ArrayList<>();

        while (left <= right && high <= low) {

            for (int j = left; j <= right; j++) {
                res.add(matrix[high][j]);
            }
            high++;

            for (int i = high; i <= low; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 注意后两个有判断
            if (low >= high) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[low][j]);
                }
            }
            low--;

            if (left <= right) {
                for (int i = low; i >= high; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }

        return res;

    }
}
