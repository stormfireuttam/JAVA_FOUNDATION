package LinkedList;

public class AddTwoLinkedList {
    static class Node {
        Node next;
        int data;
        Node(int data) {
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
        public static LinkedList addList(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int oc = addListHelper(one.head, one.size, two.head, two.size, res);
            if (oc > 0)
                res.addFirst(oc);
            return res;
        }
        private static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
            if (one == null && two == null)
                return 0;
            int sum;
            if (pv1 > pv2) {
                int oc = addListHelper(one.next, pv1 - 1, two, pv2, res);
                sum = oc + one.data;
            }
            else if (pv1 < pv2) {
                int oc = addListHelper(one, pv1, two.next, pv2 - 1, res);
                sum = oc + two.data;
            }
            else {
                int oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
                sum = oc + one.data + two.data;
            }
            res.addFirst(sum % 10);
            return sum / 10;
        }
    }
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(9);
        list1.addLast(9);
        list1.addLast(9);
        list1.display();
        LinkedList list2 = new LinkedList();
        list2.addLast(1);
        list2.addLast(0);
        list2.addLast(2);
        list2.addLast(2);
        list2.addLast(1);
        list2.display();
        LinkedList list = LinkedList.addList(list1, list2);
        list.display();
    }
}
