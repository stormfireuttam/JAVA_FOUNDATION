/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions,
    but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction.
One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number fee
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5
Sample Input
12
10 15 17 20 16 18 22 20 22 20 23 25
3
Sample Output
13
 */
package BuyAndSellStocks;

import java.util.Scanner;

public class InfiniteTransactionsWithTransactionFees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int fee = sc.nextInt();
        /*
        At each instance
            we update our buy state and sell state
            we check if buying or selling at particular instance would create profit or not
            For Buy state we compare it with our previous buyState and difference between
                the amount we need to pay for buying after subtracting the profit we made in previous state
            For Sell state we compare previous sell state and the sum of previous buyState and current share price
                along with subtracting the fee
         */
        int buyState = 0 - a[0], sellState = 0;
        for (int i = 1; i < n; i++) {
            int currBuyState = Math.max(buyState, sellState - a[i]);
            int currSellState = Math.max(sellState, a[i] + buyState - fee);
            buyState = currBuyState;
            sellState = currSellState;
        }
        System.out.println(sellState);
    }
}
