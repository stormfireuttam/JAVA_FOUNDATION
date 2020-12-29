/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number k
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2
Sample Input
6
9
6
7
6
3
8
1

Sample Output
5
 */
package BuyAndSellStocks;

import java.util.Scanner;

public class KTransactionsAllowed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int dp[][] = new int[k + 1][n];
        /*
        We will keep track of the max value in the previous row upto that day
        and while adding value to the dp we will compare it with the previous value in the current row
        So the formula would be something like
        dp[i][j] = Math.max( (max of previous row entries upto days - 1) + a[days], dp[transaction][days - 1])
         */
        for (int noOfTransactions = 1; noOfTransactions <= k; noOfTransactions ++) {
            int max = Integer.MIN_VALUE;
            for (int days = 1; days < n; days++) {
                max = Math.max(max, dp[noOfTransactions - 1][days - 1] - a[days - 1]);
                dp[noOfTransactions][days] = Math.max(dp[noOfTransactions][days - 1], max + a[days]);
            }
        }
        System.out.println(dp[k][n - 1]);
    }
}
