package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class _Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int col = 0;
        for (int i = 0; i < numRows; i++) {
            col++;
            // 记得要在外层
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                if (j == 0 || j == (col - 1)) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            // 记得要添加
            res.add(row);
        }

        return res;
    }
}
