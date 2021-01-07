/*
1. You are given an infix expression.
2. You are required to evaluate and print it's value.
Input Format
Input is managed for you
Output Format
Value of infix expression
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
2 + 6 * 4 / 8 - 3
Sample Output
2
 */
package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        //create two stacks one stack for operators and the other stack for operands
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (char c : ch) {
            /* For every character just follow the following rules:
                    1) Push all the numbers to the operands stack
                    2) If you get an opening bracket (  push it to the operands stack
                    3) If you get a closing brackets pop all the elements in the operators
                        stack upto the opening bracket
                    4) Pop all the operators from the stack if their priority is equal to or
                        greater than the current character
             */
            if(c >= '0' && c <= '9') {
                operands.push((int)(c - '0'));
            }
            else if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                if (c != '(' && operators.size() > 0) {
                    while (operators.size() > 0) {
                        if((c == '+' || c == '-') && (operators.peek() == '+' || operators.peek() == '-'
                                || operators.peek() == '*' || operators.peek() == '/'))
                        {
                            operands.push(performOperation(operands.pop(), operands.pop(), operators.pop()));
                        }
                        else if ((c == '*' || c == '/') && (operators.peek() == '*' || operators.peek() == '/')) {
                            operands.push(performOperation(operands.pop(), operands.pop(), operators.pop()));
                        }
                        else
                            break;
                    }
                }
                operators.push(c);
            }
            else if(c == ')') {
                while (operators.peek() != '(') {
                    operands.push(performOperation(operands.pop(), operands.pop(), operators.pop()));
                }
                operators.pop();
            }
        }
        while (operators.size() > 0) {
            operands.push(performOperation(operands.pop(), operands.pop(), operators.pop()));
        }
        System.out.println(operands.pop());
    }

    private static int performOperation(int b, int a, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
        }
        return -1;
    }
}
