package org.example.practice;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix.length - 1;

        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }

            if (target < matrix[x][y]) {
                y--;
            } else {
                x++;
            }
        }

        return false;
    }
}
