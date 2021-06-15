package com.algorithm.sum;

/**
 * xiaog
 */

class SolutionLinkAddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        while (true) {
            int sum = node.val;
            sum += sumVal(l1);
            sum += sumVal(l2);

            if (sum >= 10) {
                node.val = sum - 10;
                node.next = new ListNode(1);
                node = node.next;
            } else {
                node.val = sum;
                if (hasNext(l1) || hasNext(l2)) {
                    node.next = new ListNode(0);
                    node = node.next;
                } else {
                    break;
                }
            }

            if (hasNext(l1))
                l1 = l1.next;
            else
                l1 = null;
            if (hasNext(l2))
                l2 = l2.next;
            else
                l2 = null;
        }

        return result;
    }

    private int sumVal(ListNode node) {
        int sum = 0;
        if (!isEmpty(node)) {
            sum += node.val;
        }
        return sum;
    }

    private boolean hasNext(ListNode node) {
        return node != null && node.next != null;
    }

    private boolean isEmpty(ListNode l) {
        return l == null;
    }
}

public class LinkAddTwoNums {
    public static void main(String[] args) {
        //final ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //final ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        //final ListNode l1 = new ListNode(0);
        //final ListNode l2 = new ListNode(0);

        final ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        final ListNode l2 = new ListNode(9, new ListNode(9));


        final ListNode result = new SolutionLinkAddTwoNums().addTwoNumbers(l1, l2);
        System.out.println("result = " + result);
    }
}
