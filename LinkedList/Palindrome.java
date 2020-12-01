package LinkedList;

public class Palindrome {
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
        void display() {
            Node curr = head;
            while (curr != tail.next) {
                System.out.print(curr.data + "=>");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
        Node leftPtr;
        boolean isPalindrome() {
            leftPtr = head;
            return isPalindromeHelper(head);
        }
        private boolean isPalindromeHelper(Node right) {
            if (right == null)
                return true;
            boolean rres = isPalindromeHelper(right.next);
            if (rres == false)
                return false;
            else if (leftPtr.data != right.data)
                return false;
            leftPtr = leftPtr.next;
            return true;
        }
    }
    public static void main(String[] args) {
        LinkedList list  = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(20);
        list.addLast(10);
        list.display();
        System.out.println(list.isPalindrome());
        list.addLast(30);
        list.display();
        System.out.println(list.isPalindrome());
    }
}
