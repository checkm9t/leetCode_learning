package org.example.practice;

import java.util.ArrayList;
import java.util.List;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }

        ListNode[] arr = lists;
        while (arr.length > 1) {
            List<ListNode> list = new ArrayList<ListNode>();
            for (int i = 0; i < arr.length; i += 2) {
                ListNode mergeList;
                if (i + 1 == arr.length) {
                    mergeList = arr[i];
                } else {
                    mergeList = merge(arr[i], arr[i + 1]);
                }
                list.add(mergeList);
            }
            arr = list.toArray(new ListNode[0]);
        }

        return arr[0];
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }

        cur.next = p1 == null ? p2 : p1;
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
