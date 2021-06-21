package com.algorithm.linkedlist;

/**
 * xiaOgang
 */
public class SolutionReverseList {

    public ListNode reverseList1(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode restHead = head.next;
        ListNode reverseRest = reverseList(restHead);

        restHead.next = head;
        head.next = null;

        return reverseRest;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = null;

        ListNode.print(list1);
        ListNode.print(new SolutionReverseList().reverseList(list1));
    }
}
