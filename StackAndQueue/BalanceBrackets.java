/*
1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false
Input Format
A string str
Output Format
true or false
Constraints
0 <= str.length <= 100
Sample Input
[(a + b) + {(c + d) * (e / f)}]
Sample Output
true

 */
package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input[] = sc.nextLine().toCharArray();
        System.out.println(matchBrackets(input));
    }

    private static boolean matchBrackets(char[] input) {
        /*
        We use stack to check whether the string has balanced brackets or not
        If we see opening brackets we simply push them onto the stack
        If we see closing brackets we check whether the stack has opening bracket of similar type
         */
        Stack<Character> brackets = new Stack<>();
        for (char ch: input) {
            if (ch == '(' || ch == '{' || ch == '[')
                brackets.push(ch);
            else if (ch == ')') {
                if (brackets.size() == 0 || brackets.peek() != '(')
                    return false;
                brackets.pop();
            }
            else if (ch == '}') {
                if (brackets.size() == 0 || brackets.peek() != '{')
                    return false;
                brackets.pop();
            }
            else if (ch == ']') {
                if (brackets.size() == 0 || brackets.peek() != '[')
                    return false;
                brackets.pop();
            }
        }
        return (brackets.size() == 0) ? true : false;
    }
}
