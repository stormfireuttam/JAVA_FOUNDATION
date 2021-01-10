/*
1. You are required to complete the code of our MinStack class.
2. As data members you've one stack and a min element available in the class. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
      3.1. push -> Should accept new data in LIFO manner.
      3.2. pop -> Should remove and return data in LIFO manner. If not available, print
       "Stack underflow" and return -1.
      3.3. top -> Should return data in LIFO manner. If not available, print "Stack
      underflow" and return -1.
     3.4. size -> Should return the number of elements available in the stack.
     3.5. min -> Should return the smallest element available in the stack. If not
     available, print "Stack underflow" and return -1.
4. Input and Output is managed for you.

Input Format
Input is managed for you

Output Format
Output is managed for you

Constraints
None

Sample Input
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
quit

Sample Output
11
2
11

 */
package StackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumStack {
    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            // write your code here
            return data.size();
        }

        void push(int val) {
            // write your code here
            if (data.size() == 0) {
                data.push(val);
                min = val;
            }
            else {
                if (val <= min) {
                    data.push(val * 2 - min);
                    min = val;
                }
                else
                    data.push(val);
            }
        }

        int pop() {
            // write your code here
            if (data.size() == 1) {
                min = 0;
                return data.pop();
            }
            else if (data.size() > 1) {
                int val = data.peek();
                if (val < min) {
                    val = min;
                    min = min * 2 - data.peek();
                    data.pop();
                    return val;
                }
                return data.pop();
            }
            else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int top() {
            // write your code here
            if (data.size() > 0) {
                if (data.peek() < min)
                    return min;
                return data.peek();
            }
            else {
                System.out.println("Stack underflow");
                return -1;
            }
        }

        int min() {
            // write your code here
            return min;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
