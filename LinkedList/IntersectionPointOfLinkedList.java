package LinkedList;

public class IntersectionPointOfLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    static class LinkedList {
        Node head, tail;
        int size;
        LinkedList() {
            head = tail = null;
            size = 0;
        }
        void addLast(int data) {
            Node temp = new Node(data);
            if (size == 0)
            {
                tail = head = temp;
            }
            else
            {
                tail.next = temp;
                tail = temp;
            }
            size ++;
        }
        void display() {
            Node curr = head;
            while (curr != tail.next) {
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
        public static int findIntersectionPoint(LinkedList one, LinkedList two) {
            Node t1 = one.head, t2 = two.head;
            int diff = Math.abs(one.size - two.size);
            if (one.size > two.size) {
                for (int i = 0; i < diff; i++) {
                    t1 = t1.next;
                }
            } else if(two.size > one.size) {
                for (int i = 0; i < diff; i++) {
                    t2 = t2.next;
                }
            }
            while (t1 != null && t2 != null) {
                if (t1.data == t2.data)
                    break;
                t1 = t1.next;
                t2 = t2.next;
            }
            if (t1 != null && t2 != null)
                return t1.data;
            else
                return -1;
        }
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(7);
        l1.addLast(8);
        l1.display();
        LinkedList l2 = new LinkedList();
        l2.addLast(4);
        l2.addLast(5);
        l2.addLast(6);
        l2.addLast(7);
        l2.addLast(9);
        l2.display();
        System.out.println("Intersection Point is: " +
                LinkedList.findIntersectionPoint(l1, l2));
    }
}
