package LinkedList;

public class KthElementFromEnd {
    public static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
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
    public static void main(String[] args) {
        Node head = new Node(10);
        addLast(head, 20);
        addLast(head, 30);
        addLast(head, 40);
        addLast(head, 50);
        addLast(head, 60);
        addLast(head, 70);
        addLast(head, 80);
        addLast(head, 90);
        addLast(head, 100);
        displayLinkedList(head);
        findKthElementFromEnd(head, 1);
        findKthElementFromEnd(head,5);
    }
    private static void findKthElementFromEnd(Node head, int k) {
        if (head==null) return;
        Node fastPtr = head;
        int pos = 1;
        while (pos != k) {
            if (fastPtr == null) return;
            fastPtr = fastPtr.next;
            pos ++;
        }
        Node slowPtr = head;
        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        System.out.println(slowPtr.data);
    }
    private static void displayLinkedList(Node head) {
        int size = 0;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
            size ++;
        }
        System.out.println("NULL");
    }
}
