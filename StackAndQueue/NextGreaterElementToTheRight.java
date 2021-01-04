/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.

"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9
Sample Input
5
5
3
8
-2
7
Sample Output
8
8
-1
7
-1
 */
package StackAndQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToTheRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(getArray(arr)));
    }

    /*
        We traverse through the input array and each time before inserting the values in the output array
        we remove the values from the stack smaller than the current input array value
        and than we finally push the value of the current array element to our stack
     */
    private static int[] getArray(int[] arr) {
        int output[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (s.size() > 0 && s.peek() < arr[i]) {
                s.pop();
            }
            output[i] = (s.size() == 0) ? -1 : s.peek();
            s.push(arr[i]);
        }
        return output;
    }
}
