package LinkedList;

import java.util.Scanner;

public class Main {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void addLast(Node head, int data) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node temp = new Node(data);
        curr.next = temp;
    }

    public static Node addFirst(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    private static void getValueAtIndex(Node head, int i) {
        if (head == null)
            System.out.println("List Empty");
        else {
            int j = 1;
            while (j != i  && head != null) {
                head = head.next;
                j ++;
            }
            if (head == null)
                System.out.println("List is Empty");
            else
                System.out.println("Element at index " + i + " is " + head.data);
        }
    }

    private static Node removeFirst(Node head) {
        if (head == null)
            return null;
        head = head.next;
        return head;
    }
    
    private static void displayLinkedList(Node head) {
        int size = 0;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
            size ++;
        }
        System.out.println("NULL");
        System.out.println("Size of Linked List: " + size);
    }
    private static Node removeAtIndex(Node head, int index) {
        if (index < 1 || index > getSize(head))
        {
            System.out.println("Invalid arguments");
            return head;
        }
        else if (index == 1) {
            return deleteFirst(head);
        }
        else if (index == getSize(head)) {
            return deleteTail(head);
        }
        int pos = 1;
        Node curr = head;
        while (pos != index - 1 && head.next!= null) {
            curr = curr.next;
            pos ++;
        }
        curr.next = curr.next.next;
        return head;
    }
    private static Node insertAtIndex(Node head, int data, int index) {
        if (index < 0 || index > getSize(head)) {
            System.out.println("Illegal arguments");
            return null;
        }
        else if (index == 0)
            addFirst(head, data);
        else if (index == getSize(head))
            addLast(head, data);
        int i = 1;
        Node curr = head;
        while (curr != null && i < index) {
            curr = curr.next;
            i ++;
        }
        Node temp = new Node(data);
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    private static int getSize(Node head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size ++;
        }
        return size;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;
        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    private static Node deleteFirst(Node head) {
        if (head == null)   return null;
        return head.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = new Node(10);
        addLast(head, 12);
        addLast(head, 13);
        addLast(head, 14);
        displayLinkedList(head);
        head = removeFirst(head);
        displayLinkedList(head);
        getValueAtIndex(head, 2);
        head = addFirst(head, 11);
        displayLinkedList(head);
        head = deleteFirst(head);
        displayLinkedList(head);
        head = deleteTail(head);
        displayLinkedList(head);
        head = insertAtIndex(head, 20, 1);
        displayLinkedList(head);
        insertAtIndex(head, 40, 6);
        head = removeAtIndex(head,1);
        displayLinkedList(head);
    }
}
