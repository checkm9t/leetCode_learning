package org.example.practice;

public class SortList_ {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;

        l1 = sortList(l1);
        l2 = sortList(l2);

        return mergeList(l1, l2);
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }
        cur.next = p1 != null ? p1 : p2;
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
