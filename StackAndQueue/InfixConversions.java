/*
1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
Input Format
Input is managed for you
Output Format
postfix
prefix
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
a*(b-c+d)/e
Sample Output
abc-d+*e/
/*a+-bcde

 */

package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class InfixConversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char exp[] = sc.nextLine().toCharArray();
        /*
            Create three stacks
            1) prefix order
            2) postfix order
            3) operators
         */
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();
        String val1, val2;
        char op;
        /*
            For each character we follow the following rules:
            1) If the current character is a digit or letter we simply push the character
                to the postfix and prefix stacks
            2) If the current character is a '(' we simply push it to the stack
            3) If the current character is a ')' we pop all the operators upto '(' along with
                last two values of prefix and postfix stacks
            4) If we have any of the arithmetical operators we simply push them to the stack
                and before pushing them to the stack we take care that all the operators in the
                stack with precedence greater or equal to current character have been popped
                from the stack

            Other than these rules we take care of the following:
            1) For prefix
             op + val1 + val2
            2) For postfix
             val1 + val2 + op
         */
        for (char ch : exp) {
            if(Character.isLetterOrDigit(ch)) {
                prefix.push(ch + "");
                postfix.push(ch + "");
            }
            else if(ch == '(') {
                operators.push(ch);
            }
            else if(ch == ')') {
                while (operators.peek() != '(') {
                    //prefix
                    val2 = prefix.pop();
                    val1 = prefix.pop();
                    op = operators.pop();
                    prefix.push(op + val1 + val2);
                    //postifx
                    val2 = postfix.pop();
                    val1 = postfix.pop();
                    postfix.push(val1 + val2 + op);
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-'  || ch == '*'  || ch == '/' ) {
                while (operators.size() > 0) {
                    if (precedence(ch) <= precedence(operators.peek())) {
                        //prefix
                        val2 = prefix.pop();
                        val1 = prefix.pop();
                        op = operators.pop();
                        prefix.push(op + val1 + val2);
                        //postifx
                        val2 = postfix.pop();
                        val1 = postfix.pop();
                        postfix.push(val1 + val2 + op);
                    }
                    else
                        break;
                }
                operators.push(ch);
            }
        }
        while (operators.size() > 0) {
            //prefix
            val2 = prefix.pop();
            val1 = prefix.pop();
            op = operators.pop();
            prefix.push(op + val1 + val2);
            //postifx
            val2 = postfix.pop();
            val1 = postfix.pop();
            postfix.push(val1 + val2 + op);
        }
        System.out.println(prefix.pop());
        System.out.println(postfix.pop());
    }
    // Function that calculates the precedence of the operators
    public static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        return -1;
    }
}
