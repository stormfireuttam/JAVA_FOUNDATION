/*
1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?


Input Format
Input is managed for you
Output Format
Index of celebrity or none
Constraints
1 <= n <= 10^4
e1, e2, .. n * n elements belongs to the set (0, 1)

Sample Input
5
01110
01010
01010
00000
11111
Sample Output
3
 */
package StackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Celebrity {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }
    /*
        Method to find whether their is any celebrity present among the people
     */
    private static void findCelebrity(int[][] arr) {
        Stack<Integer> s = new Stack<>();
        //Firstly push all the indexes from 0 to n - 1 to the stack
        for (int i = 0; i < arr.length; i++) {
            s.push(i);
        }
        while (s.size() > 1) {
            int a = s.pop(), b = s.pop();
            if (arr[a][b] == 1) {
                // if a knows about b then b is the celebrity
                s.push(b);
            }
            else
                //If a does not know about b then a is the celebrity
                s.push(a);
        }
        //Get the last element remaining in the stack
        int x = s.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != x) {
                //if x knows about i or i does not know about x print "none"
                if (arr[x][i] == 1 || arr[i][x] == 0) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(x);
    }
}
