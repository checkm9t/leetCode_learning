package org.example.leetcode;

import org.example.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        int front = 0;
        int tail = arr.size() - 1;

        while (front < tail) {
            if (arr.get(front) != arr.get(tail)) {
                return false;
            }
            front++;
            tail--;
        }

        return true;
    }
}
