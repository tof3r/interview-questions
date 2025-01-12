package com.dawidg90.linkedlist;

public class LinkedListRelated {

    //Given a singly linked list, find the middle of the linked list. For example, if the given linked list
    // is 1->2->3->4->5 then the output should be 3.
    //If there are even nodes, then there would be two middle nodes,
    // we need to print the second middle element. For example, if the given linked list is 1->2->3->4->5->6 then the output should be 4.
    public static void printMiddle(ListNode node) {
        int count = 0;
        ListNode mid = node;
        while (node != null) {
            if (count % 2 == 1) mid = mid.next;
            ++count;
            node = node.next;
        }
        if (mid != null)
            System.out.println("The middle element is: [" + mid.data + "]\n");
    }

    //Given pointer to the head node of a linked list,
    // the task is to reverse the linked list.
    // We need to reverse the list by changing the links
    // between nodes.
    //Examples
    //Input: Head of following linked list
    //1->2->3->4->NULL
    //Output: Linked list should be changed to,
    //4->3->2->1->NULL
    //
    //Input: Head of following linked list
    //1->2->3->4->5->NULL
    //Output: Linked list should be changed to,
    //5->4->3->2->1->NULL
    //
    //Input: NULL
    //Output: NULL
    //
    //Input: 1->NULL
    //Output: 1->NULL
    public static ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void printNthFromTheEndOfLinkedList(int nthElement, MyLinkedList list) {
        ListNode mainPointer = list.head;
        ListNode referencePointer = list.head;

        int count = 0;
        if (list.head != null) {
            while (count < nthElement) {
                if (referencePointer == null) {
                    System.out.println(nthElement + " is greater than the list size");
                    return;
                }
                referencePointer = referencePointer.next;
                count++;
            }
            if (referencePointer == null) {
                if (mainPointer != null) {
                    System.out.println("Node #" + nthElement + " from the end is: " + mainPointer.data);
                }
            } else {
                while (referencePointer != null) {
                    mainPointer = mainPointer.next;
                    referencePointer = referencePointer.next;
                }
                System.out.println("Node #" + nthElement + " from the end is: " + mainPointer.data);
            }
        }
    }

    //Merge two given linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.data < list2.data) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
