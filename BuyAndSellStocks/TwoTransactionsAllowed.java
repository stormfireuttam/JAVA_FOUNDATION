/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
30
 */
package BuyAndSellStocks;

import java.util.Scanner;

public class TwoTransactionsAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        /*
            We will create a leftDp and a rightDp
            and keep track of profit from both the ends
            so that no transaction is overlapping
         */
        int dpLeft[] = new int[n];
        int dpRight[] = new int[n];
        int leastPrice = a[0];
        int maxPrice = a[n - 1];

        dpLeft[0] = 0;
        for (int i = 1; i < n; i++) {
            leastPrice = Math.min(a[i], leastPrice);
            dpLeft[i] = Math.max(dpLeft[i - 1], a[i] - leastPrice);
        }

        dpRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i --) {
            maxPrice = Math.max(maxPrice, a[i]);
            dpRight[i] = Math.max(dpRight[i + 1], maxPrice - a[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(dpRight[i] + dpLeft[i], maxProfit);
        }
        System.out.println(maxProfit);
    }
}
