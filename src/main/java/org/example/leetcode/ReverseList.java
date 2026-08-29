package org.example.leetcode;

import org.example.common.ListNode;

public class ReverseList {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 这个prev不需要dummy节点
        // 否则反转过来会多一个节点
        ListNode prev = null;
        ListNode cur = head;
        ListNode post;

        while (cur != null) {
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }

        // 这个时候cur已经=null了
        // 注意：返回prev才是对的
        return prev;
    }
}
