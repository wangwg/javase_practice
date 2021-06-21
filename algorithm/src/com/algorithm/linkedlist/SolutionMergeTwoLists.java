package com.algorithm.linkedlist;

/**
 * xiaOgang LeetCode #21
 */
public class SolutionMergeTwoLists {

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        ListNode sentienl = new ListNode(-1);
        ListNode prev = sentienl;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }

        prev.next = (l1 == null) ? l2 : l1;
        return sentienl.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list13 = new ListNode(4);
        ListNode list21 = new ListNode(1);
        ListNode list22 = new ListNode(3);
        ListNode list23 = new ListNode(4);

        list11.next = list12;
        list12.next = list13;
        list13.next = null;

        list21.next = list22;
        list22.next = list23;
        list23.next = null;

        ListNode.print(list11);
        ListNode.print(list21);

        ListNode result = new SolutionMergeTwoLists().mergeTwoLists(list11, list21);

        ListNode.print(result);
    }
}
