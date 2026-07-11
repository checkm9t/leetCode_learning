package org.example.practice;

public class MinWindow {
    public String minWindow(String s, String t) {
        int[] sCnt = new int[128];
        int[] tCnt = new int[128];
        int sl = s.length();
        int tl = t.length();
        int resL = -1;
        int resR = -1;

        if (sl < tl) {
            return "";
        }

        for (int i = 0; i < tl; i++) {
            tCnt[t.charAt(i) - 'A']++;
        }

        int left = 0;
        int right = 0;

        while (right < sl) {
            // 窗口右移要放在前面，不然会漏掉最后一步
            sCnt[s.charAt(right) - 'A']++;
            right++;

            while (check(sCnt, tCnt)) {
                if (resL == -1 || (resR - resL) > (right - left)) {
                    resR = right;
                    resL = left;
                }
                sCnt[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return resL == -1 ? "" : s.substring(resL, resR);
    }

    public boolean check(int[] sCnt, int[] tCnt) {
        for (int i = 0; i < tCnt.length; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
