package com.collection_pr.programs_collection.linkedList;

public class ReversedLinkedList {
    public static void main(String[] args) {

        // Create linked list: 10 → 20 → 30 → 40 → null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse
        head = reverse(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }

    // Print list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // save next
            current.next = prev; // reverse link
            prev = current; // move prev
            current = next; // move current
        }
        return prev;
        // logic
        /*
         * 1st loop
         * next:20->30->40->null
         * current.next:null
         * prev:10->null
         * current:20->30->40->null
         * 
         * 2nd loop
         * next:30->40->null
         * current.next:10->null
         * prev:20->10->null
         * current:30->40->null
         * 
         * 3rd loop
         * next:40->null
         * current.next:20->10->null
         * prev:30->20->10->null
         * current:40->null
         * 
         * 4th loop
         * next:null
         * current.next:30->20->10->null
         * prev:40->30->20->10->null
         * current:null
         */
    }
}
