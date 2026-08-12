package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {

    boolean[] diag1;
    boolean[] diag2;
    boolean[] cols;
    List<List<String>> res;
    int[] queens;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        diag1 = new boolean[n * 2];
        diag2 = new boolean[n * 2];
        cols = new boolean[n];
        queens = new int[n];
        Arrays.fill(queens, -1);

        dfs(0, n);

        return res;
    }

    public void dfs(int i, int n) {
        if (i == n) {
            res.add(generateAns(queens));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!diag1[i - j + n] && !diag2[i + j] && !cols[j]) {
                queens[i] = j;
                diag1[i - j + n] = true;
                diag2[i + j] = true;
                cols[j] = true;
                dfs(i + 1, n);
                diag1[i - j + n] = false;
                diag2[i + j] = false;
                cols[j] = false;
                queens[i] = -1;
            }
        }
    }

    public List<String> generateAns(int[] queens) {
        int n = queens.length;
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == queens[i]) {
                    row.append('Q');
                } else {
                    row.append('.');
                }

            }
            board.add(row.toString());
        }
        return board;
    }
}
