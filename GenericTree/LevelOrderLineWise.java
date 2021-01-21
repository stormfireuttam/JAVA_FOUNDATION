/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes from left to right (level by level) all separated by a space.
All levels on separate lines starting from top to bottom.
Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10
20 30 40
50 60 70 80 90 100
110 120
 */
package GenericTree;

import com.sun.source.tree.IfTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLineWise {
    private static class Pair{
        Node node;
        int level;
        Pair() {}
        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    private static Node construct(int arr[]) {
        Node root = null;
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
                }
                else {
                    root = t;
                }
                s.push(t);
            }
        }
        return root;
    }
    /*
    In this approach we use a marker to mark the end of the level
     */
    private static void levelOrderLinewise(Node node) {
        Queue<Node> mainQ = new ArrayDeque<>();
        if (node == null) return;
        mainQ.add(node);
        Node invalid = new Node();
        invalid.data = -1;
        mainQ.add(invalid);
        while (mainQ.size() > 0) {
            node = mainQ.remove();
            if (node != invalid) {
                System.out.print(node.data + " ");
                for (Node child: node.children) {
                    mainQ.add(child);
                }
            }
            else {
                System.out.println();
                if (mainQ.size() > 0) {
                    mainQ.add(invalid);
                }
            }
        }
    }
    /*
    In this approach we compute the size at each level and use it to print the nodes at each level
     */
    private static void levelOrderLineWise2(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        if (node == null) return;
        q.add(node);
        while (q.size() > 0) {
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                node = q.remove();
                System.out.print(node.data + " ");
                for (Node child: node.children) {
                    q.add(child);
                }
            }
            System.out.println();
        }
    }
    /*
    This time we will store the nodes in form of Pairs
    Pair would basically consist of the node and the level of the node
     */
    private static void levelOrderLineWise3(Node node) {
        if (node == null)
            return;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));
        int level = 1;
        while (q.size() > 0) {
            Pair p = q.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
                System.out.print(p.node.data + " ");
            }
            else {
                System.out.print(p.node.data + " ");
            }
            for (Node child: p.node.children) {
                q.add(new Pair(child, p.level + 1));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        levelOrderLinewise(root);
        levelOrderLineWise2(root);
        levelOrderLineWise3(root);
    }
}
