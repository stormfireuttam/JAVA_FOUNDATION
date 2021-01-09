/*
1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Input Format
Input is managed for you
Output Format
value, a number
infix
prefix
Constraints
1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
264*8/+3-
Sample Output
2
((2+((6*4)/8))-3)
-+2/*6483
 */
package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class PostfixConversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char exp[] = sc.nextLine().toCharArray();
        /*
            First of all we create three stacks
            - valueStack
            - infix
            - prefix
         */
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        /*
            We follow the following rules:

         */
        for (char ch : exp) {
            if (Character.isLetterOrDigit(ch)) {
                valueStack.push((int)(ch - '0'));
                infix.push(ch + "");
                prefix.push(ch + "");
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                valueStack.push(performOperation(valueStack.pop(), valueStack.pop(), ch));
                // Prefix evaluation
                String val2 = prefix.pop(), val1 = prefix.pop();
                prefix.push(ch + val1 + val2);
                // Infix evaluation
                val2 = infix.pop();
                val1 = infix.pop();
                infix.push("(" + val1 + ch + val2 + ")");
            }
        }
        System.out.println(valueStack.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }
    public static int performOperation(int b, int a, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
        }
        return -1;
    }
}
