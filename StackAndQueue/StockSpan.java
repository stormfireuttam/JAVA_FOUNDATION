/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the prices of a share on n days.
3. You are required to find the stock span for n days.
4. Stock span is defined as the number of days passed between the current day and the first day before today when price was higher than today.

e.g.
for the array [2 5 9 3 1 12 6 8 7]
span for 2 is 1
span for 5 is 2
span for 9 is 3
span for 3 is 1
span for 1 is 1
span for 12 is 6
span for 6 is 1
span for 8 is 2
span for 7 is 1
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9
 */
package StackAndQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(getArray(a)));
    }
    /*
        We store indexes of elements in our stack
        We check the current value of array with the values in the stack
        and pop all the values smaller than the current value of array
        If size of stack reduces to zero we set the answer as 1 value greater than the index value
        else we set the answer to the difference between current index value and top value of the stack
     */
    private static int[] getArray(int[] a) {
        int output[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (s.size() > 0 && a[s.peek()] < a[i]) {
                s.pop();
            }
            output[i] = (s.size() == 0) ? (i + 1) : (i - s.peek());
            s.push(i);
        }
        return output;
    }
}
