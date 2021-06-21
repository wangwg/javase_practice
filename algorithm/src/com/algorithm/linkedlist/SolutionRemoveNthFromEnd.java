package com.algorithm.linkedlist;

/**
 * xiaOgang
 */
public class SolutionRemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentienl = new ListNode(-1, head);
        ListNode first = sentienl;
        ListNode second = sentienl;

        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return sentienl.next;
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        //ListNode list2 = new ListNode(2);
//        ListNode list3 = new ListNode(3);
//        ListNode list4 = new ListNode(4);
//        ListNode list5 = new ListNode(5);

        list1.next = null;
//        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;
//        list5.next = null;
//        list1.next = list2;
//        list2.next = null;
        ListNode.print(list1);

        ListNode.print(new SolutionRemoveNthFromEnd().removeNthFromEnd(list1, 1));

    }
}
