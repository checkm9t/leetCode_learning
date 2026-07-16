package org.example.practice;

public class _RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        //这个很重要
        ListNode prev = dummy;
        ListNode post = head;

        for (int i = 0; i < n; i++) {
            post = post.next;
        }

        while (post != null) {
            prev = prev.next;
            post = post.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
