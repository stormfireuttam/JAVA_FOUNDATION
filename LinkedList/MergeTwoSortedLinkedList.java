package LinkedList;

public class MergeTwoSortedLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    private static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(30);
        head1.next.next = new Node(50);
        head1.next.next = new Node(90);
        display(head1);
        Node head2 = new Node(20);
        head2.next = new Node(40);
        head2.next.next = new Node(60);
        head2.next.next.next = new Node(80);
        display(head2);
        Node head3 = mergeSortedList(head1, head2);
        display(head3);
    }
    private static Node addLast(Node head, int data) {
        Node curr = head;
        Node temp = new Node(data);
        if(curr == null)
            return temp;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
    private static Node mergeSortedList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        else if (head1 != null && head2 == null) {
            return head1;
        }
        else if (head1 == null && head2 != null) {
            return head2;
        }
        Node head = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                head = addLast(head, head1.data);
                head1 = head1.next;
            }
            else {
                head = addLast(head, head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            head = addLast(head, head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            head = addLast(head, head2.data);
            head2 = head2.next;
        }
        return head;
    }
}
