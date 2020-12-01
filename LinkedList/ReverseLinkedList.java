package LinkedList;

public class ReverseLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    static class LinkedList {
        Node head;
        Node tail;
        int size;
        public LinkedList() {
            head = tail = null;
            size = 0;
        }
        void display() {
            Node curr = head;
            while (curr != tail.next) {
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.println("NULL");
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
        void reverseIterativePointer() {
            Node curr = head, prev = null;
            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }
        void recursiveReversePointer() {
            recursiveReverseHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }
        private void recursiveReverseHelper(Node node) {
            if (node == null)
                return;
            recursiveReverseHelper(node.next);
            if (node == tail)
                return;
            node.next.next = node;
        }

        void displayReverse() {
            displayReverseHelper(head);
            System.out.println("NULL");
        }
        private void displayReverseHelper(Node node) {
            if (node == null)
                return;
            displayReverseHelper(node.next);
            System.out.print(node.data + "->");
        }

        Node lNode;
        void reverseRecursiveData() {
            lNode = head;
            reverseRecursiveDataHelper(head, 0);
        }
        private void reverseRecursiveDataHelper(Node right, int floor) {
            if (right == null)
                return;
            reverseRecursiveDataHelper(right.next, floor + 1);
            if (floor >= size / 2) {
                int temp = lNode.data;
                lNode.data = right.data;
                right.data = temp;

                lNode = lNode.next;
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
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.display();
        list.reverseIterativePointer();
        list.display();
        list.recursiveReversePointer();
        list.display();
        list.displayReverse();
        list.reverseRecursiveData();
        list.display();
    }
}
