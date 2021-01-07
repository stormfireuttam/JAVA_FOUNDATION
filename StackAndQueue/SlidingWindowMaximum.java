/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.
e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4,
    the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
 */
package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        //  Create an array of next greater element
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[n];
        nge[n - 1] = n;
        s.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (s.size() > 0 && a[s.peek()] < a[i]) {
                s.pop();
            }
            nge[i] = (s.size() == 0) ? n : s.peek();
            s.push(i);
        }
        // At each iteration check if the next greater element is within the range
        // if it is not within the range print the current value
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            System.out.println(a[j]);
        }
    }
}
