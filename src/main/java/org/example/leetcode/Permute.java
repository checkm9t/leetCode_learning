package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {

    List<List<Integer>> res;
    Set<Integer> visited;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new HashSet<>();

        dfs(nums, 0, new ArrayList<>());

        return res;

    }

    public void dfs(int[] nums, int cnt, List<Integer> tmp) {
        if (cnt == nums.length) {
            res.add(new ArrayList<>(tmp));
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            visited.add(nums[i]);
            dfs(nums, cnt + 1, tmp);
            tmp.remove(tmp.size() - 1);
            visited.remove(nums[i]);
        }
    }
}
