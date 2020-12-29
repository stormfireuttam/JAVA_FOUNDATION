/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
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
11 6 7 19 4 1 6 18 4
Sample Output
17
 */
package BuyAndSellStocks;

import java.util.Scanner;

public class SingleTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = sc.nextInt();
        }
        /*
            Find out the least value among the values visited
            and calculate the difference between current value and least value at each point
            and compare the difference with the maxProfit
         */
        int least = a[0], maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            least = Math.min(least, a[i]);
            maxProfit = Math.max(maxProfit, a[i] - least);
        }
        System.out.println(maxProfit);
    }
}
