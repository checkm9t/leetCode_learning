package org.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            StringBuilder normStr = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    // 这里的拼接逻辑是 数字+字母
                    normStr.append(counts[i]);
                    normStr.append((char) ('a' + i));
                }
            }

            List<String> list = map.getOrDefault(normStr.toString(), new ArrayList<>());
            list.add(str);
            map.put(normStr.toString(), list);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
