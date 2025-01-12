package com.dawidg90.linkedlist;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nFind the middle of a given linked list time O(n) space O(1)");
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int p = 5; p > 0; p--) {
            myLinkedList.push(myLinkedList.head, p);
            myLinkedList.printList(myLinkedList.head);
            LinkedListRelated.printMiddle(myLinkedList.head);
        }

        System.out.println("\nReverse linked list time O(n) space O(1)");
        myLinkedList.head = new ListNode(85);
        myLinkedList.head.next = new ListNode(15);
        myLinkedList.head.next.next = new ListNode(4);
        myLinkedList.head.next.next.next = new ListNode(20);
        System.out.println("Given list: ");
        myLinkedList.printList(myLinkedList.head);
        myLinkedList.head = LinkedListRelated.reverseLinkedList(myLinkedList.head);
        System.out.println("\nReversed: ");
        myLinkedList.printList(myLinkedList.head);

        System.out.println("\nN'th node from the end of linked list time O(n) space O(1)");
        MyLinkedList list = new MyLinkedList();
        list.push(20);
        list.push(4);
        list.push(15);
        list.push(1);
        list.push(66);
        list.push(2);
        list.push(45);
        LinkedListRelated.printNthFromTheEndOfLinkedList(4, list);

        System.out.println("\nMerge two linked list time O(n) space O(n)");
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // 1.3.5 LinkedList created

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);

        // 0.2.4 LinkedList created

        ListNode mergedhead = LinkedListRelated.mergeTwoLists(head1, head2);
        myLinkedList.printList(mergedhead);
    }
}
