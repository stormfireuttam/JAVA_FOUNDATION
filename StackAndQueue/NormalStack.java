/*
1. You are required to complete the code of our CustomStack class. The class should mimic the behaviour of java.util.Stack class and implement LIFO semantic.
2. Here is the list of functions that you are supposed to complete
   2.1. push -> Should accept new data if there is space available in the underlying 
   array or print "Stack overflow" otherwise.
   2.2. pop -> Should remove and return last data if available or print "Stack 
   underflow" otherwise and return -1.
   2.3. top -> Should return last data if available or print "Stack underflow" 
   otherwise and return -1.
   2.4. size -> Should return the number of elements available in the stack.
   2.5. display -> Should print the elements of stack in LIFO manner (space- 
   separated) ending with a line-break.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
5
push 10
display
push 20
display
push 30
display
push 40
display
push 50
display
push 60
display
top
pop
display
top
pop
display
top
pop
display
top
pop
display
top
pop
display
top
pop
quit
Sample Output
10 
20 10 
30 20 10 
*/


import java.io.*;
import java.util.*;

public class Main {

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            // write ur code here
            return tos + 1;
        }

        void display() {
            // write ur code here
            int t = tos;
            while (t >= 0) {
                System.out.print(data[t--] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            // write ur code here
            tos++;
            if (tos < data.length) {
                data[tos] = val;
            } else {
                tos--;
                System.out.println("Stack overflow");
            }
        }

        int pop() {
            // write ur code here
            if (tos >= 0) {
                tos--;
                return data[tos + 1];
            }
            System.out.println("Stack underflow");
            return -1;
        }

        int top() {
            // write ur code here
            if (tos >= 0) {
                return data[tos];
            }
            System.out.println("Stack underflow");
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack(n);

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
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = br.readLine();
        }
    }
}
