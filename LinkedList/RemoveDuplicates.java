package LinkedList;

public class RemoveDuplicates {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static class LinkedList {
        Node head;
        Node tail;
        int size;
        LinkedList() {
            head = tail = null;
            size = 0;
        }
        void display() {
            Node curr = head;
            while (curr != tail.next) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
        void addLast(int data) {
            Node temp = new Node(data);
            if (size == 0) {
                head = temp;
                tail = temp;
                size ++;
            }
            else {
                tail.next = temp;
                tail = temp;
                size ++;
            }
        }
        public void removeDuplicates() {
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (curr.data == curr.next.data) {
                    curr.next = curr.next.next;
                }
                else
                    curr = curr.next;
                tail = curr;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(4);
        list.display();
        list.removeDuplicates();
        list.display();
    }
}
