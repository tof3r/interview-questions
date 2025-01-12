package com.dawidg90.linkedlist;

public class MyLinkedList {
    ListNode head;

    void push(ListNode head_ref, int new_data) {
        // Allocate node
        ListNode new_node = new ListNode(new_data, head_ref);

        // Move the head to point to the new node
        head = new_node;
    }

    void push(int newData) {
        ListNode node = new ListNode(newData);
        node.next = head;
        head = node;
    }

    // A utility function to print a given linked list
    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
