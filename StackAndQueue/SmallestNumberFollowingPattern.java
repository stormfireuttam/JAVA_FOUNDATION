/*
1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
Input Format
Input is managed for you
Output Format
Smallest sequence of digits (from 1 to 9) without duplicacy and following the pattern
Constraints
0 < str.length <= 8
str contains only 'd' and 'i'
Sample Input
ddddiiii
Sample Output
543216789
 */
package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        /*
            The logic for this problem is pretty straight forward
            What you need to do is
            Initially set n to 1
            Now there are two possible scenarios either d(decreasing) or i(increasing)
            - if d arises we simply push n to stack and increment value of n
            - if i arises we push n to stack, increment its value and then pop
                all the values from the stack
            At the end push the value of n
            and pop all values from stack as well
         */
        Stack<Integer> stack = new Stack<>();
        int n = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'd') {
                stack.push(n ++);
            }
            else {
                stack.push(n ++);
                while (stack.size() > 0) {
                    System.out.print(stack.pop());
                }
            }
        }
        stack.push(n);
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}
