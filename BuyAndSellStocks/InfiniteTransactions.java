/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions.
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

public class InfiniteTransactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        /*
            Initially set BuyDate and SellDate to zero index
         */
        int buyDate = 0, sellDate = 0, maxProfit = 0;
        for (int i = 1; i < n; i++) {
            /*
             If the current value is greater than previous value
             which means their is an increasing trend
             For such a case we will increment our sell date
             */
            if (a[i] >= a[i - 1]) {
                sellDate ++;
            }
            /*
            If we find out that the current value is less than the previous value
            than we will collect the profit we have made till now
            and set the buyDate and sellDate to the current index
             */
            else {
                maxProfit += a[sellDate] - a[buyDate];
                sellDate = buyDate = i;
            }
        }
        // If their is an upward trend in the last days as well than just simply add it to profit as well
        maxProfit += a[sellDate] - a[buyDate];
        System.out.println(maxProfit);
    }
}
