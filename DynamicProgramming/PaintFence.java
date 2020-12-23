/*
1. You are given a number n and a number k in separate lines, representing the number of fences
    and number of colors.
2. You are required to calculate and print the number of ways
    in which the fences could be painted so that not more than two fences have same colors.
Input Format
    A number n
    A number k
Output Format
    A number representing the number of ways in which the fences
    could be painted so that not more than two fences have same colors.
Constraints
    1 <= n <= 10
    1 <= k <= 10
Sample Input
    8
    3
Sample Output
    3672
 */
package DynamicProgramming;

import java.util.Scanner;

public class PaintFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfFences = sc.nextInt();
        int numberOfColors = sc.nextInt();
        if(numberOfFences == 1) {
            System.out.println(0);
        }
        else {
         /*
               (currLastTwoSame)i,i ==> lastTwoDifferent
               (currLastTwoDiff)i,j ==> (lastTwoSame + lastTwoDifferent) * (numberOfColors - 1)
          */
            int lastTwoSame = numberOfColors;
            int lastTwoDifferent = numberOfColors * (numberOfColors - 1);
            for (int i = 3; i <= numberOfFences; i++) {
                int currLastTwoSame = lastTwoDifferent;
                int currLastTwoDifferent = (lastTwoSame + lastTwoDifferent) * (numberOfColors - 1);
                lastTwoSame = currLastTwoSame;
                lastTwoDifferent = currLastTwoDifferent;
            }
            System.out.println(lastTwoSame + lastTwoDifferent);
        }
    }
}
