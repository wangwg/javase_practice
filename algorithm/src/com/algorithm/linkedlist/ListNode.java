package com.algorithm.linkedlist;

/**
 * xiaOgang
 */
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

    public static void print(ListNode list) {
        ListNode temp = list;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}