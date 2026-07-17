package org.example.practice;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = dummy;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode p1 = tmp.next;
            ListNode p2 = tmp.next.next;

            p1.next = p2.next;
            p2.next = p1;
            tmp.next = p2;
            tmp = p1;
        }

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
