/*
1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
Input Format
    A number n
    A number m
Output Format
    A number representing the number of ways in which the number of ways floor can be tiled using tiles.
Constraints
    1 <= n <= 100
    1 <= m <= 50
Sample Input
    39
    16
Sample Output
    61
 */
package DynamicProgramming;

import java.util.Scanner;

public class TilingWithM_1Tiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*  The dimensions of floor are n * m
            The tiles we are having have dimension as m * 1
         */
        int n = sc.nextInt();
        int m = sc.nextInt();
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // If i is less than m
            // Than the tiles can be placed vertically only
            if (i < m) {
                dp[i] = 1;
            }
            // When i is equal to m there are two possible ways
            // All the tiles can be placed vertically
            // All the tiles can be placed horizontally
            else if (i == m) {
                dp[i] = 2;
            }
            // for ith dimension ->     if we place 1 tile vertically then the remaining would be f(i - 1)
            //                   ->     if we place 1 tile horizontally then the remaining would be f(i - m)
            else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        System.out.println(dp[n]);
    }
}
