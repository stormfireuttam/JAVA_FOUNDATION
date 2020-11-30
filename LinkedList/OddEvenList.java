package LinkedList;

public class OddEvenList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
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
        void addLast(int data) {
            Node temp = new Node(data);
            if (size == 0) {
                head = tail =  temp;
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
                System.out.print(curr.data +  "->");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
        LinkedList oddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            Node curr = head;
            while (curr != tail.next) {
                if (curr.data % 2 == 0)
                    even.addLast(curr.data);
                else
                    odd.addLast(curr.data);
                curr = curr.next;
            }
            odd.tail.next = even.head;
            odd.tail = even.tail;
            odd.size += even.size;
            return odd;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(9);
        list.addLast(7);
        list.addLast(8);
        list.addLast(1);
        list.addLast(6);
        list.addLast(5);
        list.addLast(4);
        list.display();
        list = list.oddEven();
        list.display();
        System.out.println(list.head.data + " " + list.tail.data + " " + list.size);
    }
}
