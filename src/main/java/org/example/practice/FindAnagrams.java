package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] sNum = new int[26];
        int[] pNum = new int[26];
        int l1 = s.length();
        int l2 = p.length();
        if (l1 < l2) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < l2; i++) {
            sNum[s.charAt(i) - 'a']++;
            pNum[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i + l2 < l1; i++) {
            if (equal(sNum, pNum)) {
                res.add(i);
            }
            sNum[s.charAt(i) - 'a']--;
            sNum[s.charAt(i + l2) - 'a']++;
        }

        if (equal(sNum, pNum)) {
            res.add(l1 - l2);
        }

        return res;

    }

    public boolean equal(int[] sNum, int[] pNum) {
        for (int i = 0; i < 26; i++) {
            if (sNum[i] != pNum[i]) {
                return false;
            }
        }
        return true;
    }
}

