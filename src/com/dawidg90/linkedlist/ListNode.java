package com.dawidg90.linkedlist;

public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
