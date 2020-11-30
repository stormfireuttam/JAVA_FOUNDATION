package LinkedList;

public class FindMiddleOfLinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
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
        findMiddleOfLinkedList(head);
        System.out.println("Size of linked list: " + getSize(head));
        head = reverseDI(head);
        System.out.println("After Reversing: ");
        displayLinkedList(head);
        head = reverseTwoPointer(head);
        displayLinkedList(head);
    }

    private static Node reverseTwoPointer(Node head) {
        Node curr = head, prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static int getSize(Node head) {
        int size = 0;
        while (head != null) {
            size ++;
            head = head.next;
        }
        return size;
    }
    private static Node reverseDI(Node head) {
        int l = 1, r = getSize(head);
        while (l < r) {
            Node left = getValueAtIndex(head, l);
            Node right = getValueAtIndex(head, r);
            int t = left.data;
            left.data = right.data;
            right.data = t;
            l ++;
            r --;
        }
        return head;
    }
    private static Node getValueAtIndex(Node head, int i) {
        int j = 1;
        while (j != i  && head != null) {
            head = head.next;
            j ++;
        }
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
    }
    private static void findMiddleOfLinkedList(Node head) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle of Linked List: " + slow.data);
    }
}
