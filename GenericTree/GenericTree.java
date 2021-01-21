package GenericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    /*
    Method to get the size of the given generic tree
     */
    public static int getSize(Node node) {
        int n = 1;
        for (Node child: node.children) {
            n += getSize(child);
        }
        return n;
    }
    /*
    Method to get the elements
    of the given generic tree
     */
    public static void display(Node node) {
        System.out.print(node.data + " -> ");
        for (Node child: node.children) {
            System.out.print(child.data + " ");
        }
        System.out.println(".");
        for (Node child: node.children) {
            display(child);
        }
    }
    /*
    Method to get the element with max value
    in the given generic tree
     */
    public static int getMax(Node node) {
        if (node == null) return -1;
        int max = node.data;
        for (Node child: node.children) {
            max = Math.max(max, getMax(child));
        }
        return max;
    }
    /*
    Method to get height of the tree
     */
    public static int getHeight(Node node) {
        int height = 0;
        for (Node child: node.children) {
            height = Math.max(height, 1 + getHeight(child));
        }
        return height;
    }
    /*
    You are required to complete the body of traversals function. The function is expected to visit every node. While traversing the function must print following content in different situations.
   2.1. When the control reaches the node for the first time -> "Node Pre" node.data.
   2.2. Before the control leaves for a child node from a node -> "Edge Pre"
   node.data--child.data.
   2.3. After the control comes back to a node from a child -> "Edge Post" node.data-
   -child.data.
    2.4. When the control is about to leave node, after the children have been visited
    -> "Node Post" node.data.
     */
    public static void traversalDisplay(Node node) {
        if (node == null) return;
        System.out.println("Node Pre " + node.data);
        for (Node child: node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversalDisplay(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
    }
    /*
    Level Order Traversal
     */
    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        /*
        Perform these three operations till queue becomes empty
        1) Remove the top element
        2) Print the top element
        3) Add the children of the top element
         */
        while (q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");
            for (Node child: node.children) {
                q.add(child);
            }
        }
        System.out.println(".");
    }
    /*
    Print level order line-wise
     */
    public static void levelOrderLinewise(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        if (node == null) return;
        q.add(node);
        while (q.size() > 0) {
            while (q.size() > 0) {
                node = q.remove();
                System.out.print(node.data + " ");
                for (Node child: node.children) {
                    childQ.add(child);
                }
            }
            System.out.println();
            while (childQ.size() > 0) {
                q.add(childQ.remove());
            }
        }
    }
    /*
    Main method along with constructor for the generic tree
     */
    public static void main(String[] args) {
        Node root = null;
        int arr[] = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Stack<Node> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                s.pop();
            }
            else {
                Node t = new Node();
                t.data = arr[i];
                if (s.size() > 0) {
                    s.peek().children.add(t);
                    s.push(t);
                }
                else {
                    root = t;
                    s.push(t);
                }
            }
        }
        System.out.println("Generic Tree: ");
        display(root);
        System.out.println("Size of Generic Tree: "  + getSize(root));
        System.out.println("Maximum value in generic tree: " + getMax(root));
        System.out.println("Height of generic tree: " + getHeight(root));
        System.out.println("Traversal display: ");
        traversalDisplay(root);
        System.out.println("Level Order Traversal: ");
        levelOrder(root);
        System.out.println("Level Order Traversal Linewise: ");
        levelOrderLinewise(root);
    }
}
