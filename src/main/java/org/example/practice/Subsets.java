package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> tmp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[index]);
        dfs(nums, index + 1, tmp);
        tmp.remove(tmp.size() - 1);
        dfs(nums, index + 1, tmp);
    }
}
