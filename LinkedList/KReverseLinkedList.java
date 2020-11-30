package LinkedList;

import java.util.List;

public class KReverseLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class LinkedList {
        Node head;
        Node tail;
        int size;
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
        int getFirst() {
            if (size == 0) return -1;
            return head.data;
        }
        void addFirst(int data) {
            Node temp = new Node(data);
            if (size == 0) {
                head = tail = temp;
            }
            else {
                temp.next = head;
                head = temp;
            }
            size ++;
        }
        Node removeFirst() {
            if (size == 0) {
                return null;
            }
            Node temp = head;
            head = head.next;
            temp.next = null;
            size --;
            return temp;
        }
        void display() {
            Node curr = head;
            while (curr != tail.next) {
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.println("NULL");
        }

        public LinkedList reverse(int k) {
            LinkedList prev = null;
            while (this.size > 0) {
                LinkedList curr = new LinkedList();
                if (this.size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }
                else if (this.size < k){
                    while (this.size > 0) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }
                if (prev == null) {
                    prev = curr;
                }
                else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }
            return prev;
        }
        public void displayReverseHelper(Node head) {
            if (head == null)
                return;
            displayReverseHelper(head.next);
            System.out.print(head.data + " ");
        }
        public void displayReverse() {
            displayReverseHelper(head);
            System.out.println("NULL");
        }
        public void reversePointer() {
            reversePointerHelper(head);
            head.next = null;
        }

        private void reversePointerHelper(Node head) {
            if (head == null) return;
            reversePointerHelper(head.next);
            if (head == tail) return;
            head.next.next = head;
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
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.display();
        list = list.reverse(2);
        list.display();
        list = list.reverse(4);
        list.display();
        list = list.reverse(3);
        list.display();
        list.displayReverse();
        list.display();
        list.reversePointer();
        list.display();
    }
}
