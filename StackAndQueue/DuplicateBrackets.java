/*
1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless.
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
Input Format
A string str
Output Format
true or false
Constraints
0 <= str.length <= 100
Sample Input
(a + b) + ((c + d))
Sample Output
true
 */

package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input[] = sc.nextLine().toCharArray();
        System.out.println(duplicateBrackets(input));
    }

    private static boolean duplicateBrackets(char[] input) {
        /*
            Add all the characters to the stack if they are not closing brackets
            If you detect closing brackets
                if stack is empty or stack contains '(' at top it means
                '(' and ')' have no content in between
                return true in such a case
         */
        Stack<Character> s = new Stack<>();
        for (char c: input) {
            if (c != ')') {
                s.push(c);
            }
            else {
                if(s.size() == 0 || s.peek() == '(')
                    return true;
                while (s.peek() != '(') {
                    s.pop();
                }
                s.pop();
            }
        }
        return false;
    }

}
