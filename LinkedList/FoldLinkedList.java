package LinkedList;

public class FoldLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    static class LinkedList {
        Node head, tail;
        int size = 0;
        LinkedList() {
            head = tail = null;
            size = 0;
        }
        void addLast(int data) {
            Node temp = new Node(data);
            if (size == 0) {
                head = tail = temp;
            }
            else {
                tail.next = temp;
                tail = temp;
            }
            size ++;
        }
        void display() {
            Node curr = head;
            while (curr != tail.next) {
                System.out.print(curr.data+"->");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
        Node fLeft;
        void foldList() {
            fLeft = head;
            foldListHelp(head, 0);
        }
        private void foldListHelp(Node right, int floor) {
            if (right == null)
                return;
            foldListHelp(right.next, floor + 1);
            if (floor > size/2) {
                Node temp = fLeft.next;
                fLeft.next = right;
                right.next = temp;
                fLeft = temp;
            } else if(floor == size/2) {
                tail = right;
                tail.next = null;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.display();
        list.foldList();
        list.display();
    }
}
