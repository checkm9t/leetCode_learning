package org.example.practice;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode();

        int carry = 0;
        ListNode cur = dummy;
        while (p1 != null || p2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (p1 != null) {
                v1 = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                v2 = p2.val;
                p2 = p2.next;
            }

            int vNow = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            cur.next = new ListNode(vNow);
            cur = cur.next;
        }

        // 这个要记住
        if (carry > 0) {
            cur.next = new ListNode(carry);
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
