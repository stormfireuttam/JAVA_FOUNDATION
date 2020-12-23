/*
1. You are given a number n and a number k separated by a space, representing
the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers
representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting
all houses without painting any consecutive house with same color.

Input Format
A number n
n1-0th n1-1st n1-2nd .. n1-kth
n2-0th n2-1st n2-2nd .. n2-kth
.. n number of elements

Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
 */
package DynamicProgramming;

import java.util.Scanner;

public class PaintNHousesWithNColors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int a[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int least = Integer.MAX_VALUE, secondLeast = Integer.MAX_VALUE;
        int dp[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            int newLeast = Integer.MAX_VALUE, newSecondLeast = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j] = a[i][j];
                }
                else {
                    if (dp[i - 1][j] == least)
                        dp[i][j] = a[i][j] + secondLeast;
                    else
                        dp[i][j] = a[i][j] + least;
                }

                if (dp[i][j] <= newLeast) {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                } else if (dp[i][j] < newSecondLeast) {
                    newSecondLeast = dp[i][j];
                }
            }
            least = newLeast;
            secondLeast = newSecondLeast;
        }

        least = dp[n - 1][0];
        for (int i = 1; i < k; i++) {
                least = Math.min(dp[n - 1][i], least);
        }

        System.out.println(least);
    }
}
