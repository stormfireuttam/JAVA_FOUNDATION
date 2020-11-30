package LinkedList;

public class MergeSortLinkedList {
    public static class Node{
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
        void display() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
        void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return;
            }
            else if (size == 1) {
                head = tail = null;
                size = 0;
                return;
            }
            head = head.next;
            size --;
        }
        int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }
        int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }
        int getValue(int index) {
            if(index < 1 || index > size) {
                System.out.println("Illegal Arguments");
                return -1;
            }
            else if (index == 1) {
                return getFirst();
            }
            else if (index == size) {
                return getLast();
            }
            Node curr = head;
            int pos = 1;
            while (pos != index) {
                curr = curr.next;
            }
            return curr.data;
        }
        public static Node findMiddle(Node head, Node tail) {
            Node first = head, second = head;
            while (first != tail && first.next != tail) {
                first = first.next.next;
                second = second.next;
            }
            return second;
        }
        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }
            Node mid = findMiddle(head, tail);
            LinkedList firstPart = mergeSort(head, mid);
            LinkedList secondPart = mergeSort(mid.next, tail);
            LinkedList completeList = mergeSortedList(firstPart, secondPart);
            return completeList;
        }

        private static LinkedList mergeSortedList(LinkedList firstPart, LinkedList secondPart) {
            if (firstPart == null && secondPart == null) {
                return null;
            }
            else if (firstPart != null && secondPart == null) {
                return firstPart;
            }
            else if (firstPart == null && secondPart != null) {
                return secondPart;
            }
            Node one = firstPart.head;
            Node two = secondPart.head;
            LinkedList newList = new LinkedList();
            while (one != null && two != null) {
                if (one.data < two.data) {
                    newList.addLast(one.data);
                    one = one.next;
                }
                else {
                    newList.addLast(two.data);
                    two = two.next;
                }
            }
            while (one != null) {
                newList.addLast(one.data);
                one = one.next;
            }
            while (two != null) {
                newList.addLast(two.data);
                two = two.next;
            }
            return newList;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(7);
        list.addLast(1);
        list.addLast(6);
        list.addLast(5);
        list.addLast(3);
        list.addLast(4);
        list.display();
        list = LinkedList.mergeSort(list.head, list.tail);
        list.display();
    }
}
