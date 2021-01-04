package StackAndQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToRightApproach02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(getArray(a)));
    }
    /*
        In this approach we remove elements smaller than the current value from the stack
        and set their value to the current value
        and then insert the current value to the stack

        After traversing through the array if their are any elements remaining in the stack
        we set the value of those to -1
     */
    private static int[] getArray(int[] a) {
        int op[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (s.size() > 0 && a[s.peek()] < a[i]) {
                op[s.peek()] = a[i];
                s.pop();
            }
            s.push(i);
        }
        while (s.size() > 0) {
            op[s.peek()] = -1;
            s.pop();
        }
        return op;
    }
}
