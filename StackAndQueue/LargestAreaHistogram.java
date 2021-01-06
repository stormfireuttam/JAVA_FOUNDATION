/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12
Input Format
Input is managed for you
Output Format
A number representing area of largest rectangle in histogram
Constraints
0 <= n < 20
0 <= a[i] <= 10
Sample Input
7
6
2
5
4
5
1
6
Sample Output
12
 */
package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //We iterate through the elements and set their left and right boundary
        int rightBoundary[] = new int[n];
        int leftBoundary[] = new int[n];
        //We set the boundary of rightmost element to the n and push index of it in the stack
        Stack<Integer> s = new Stack<>();
        rightBoundary[n - 1] = n;
        s.push(n - 1);
        //At each iteration we remove all the elements from the stack
        //whose value is greater than current array element
        for (int i = n - 2; i >= 0; i --) {
            while (s.size() > 0 && a[s.peek()] >= a[i]) {
                s.pop();
            }
            //If stack becomes empty we set value as the n
            // else we set the value as the value of the topmost element of the stack
            rightBoundary[i] = (s.size() == 0) ? n : s.peek();
            s.push(i);
        }
        //We follow the same approach for setting the left boundary
        //here when stack size becomes zero we insert -1 instead of n
        s = new Stack<>();
        leftBoundary[0] = -1;
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (s.size() > 0 && a[s.peek()] >= a[i]) {
                s.pop();
            }
            leftBoundary[i] = (s.size() == 0) ? -1 : s.peek();
            s.push(i);
        }
        //Finally we iterate through both the arrays and compute the area by
        //calculating the difference between rightBoundary and leftBoundary and 1 less
        //than multiplying a[i] with it
        int area = 0;
        for (int i = 0; i < n; i++) {
            area = Math.max(area, (rightBoundary[i] - leftBoundary[i] - 1) * a[i]);
        }
        System.out.println(area);
    }
}
