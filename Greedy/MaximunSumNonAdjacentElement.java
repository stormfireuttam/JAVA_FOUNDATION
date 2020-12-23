/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements
 */

package Greedy;

import java.util.Scanner;

public class MaximunSumNonAdjacentElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i ++) {
            a[i] = sc.nextInt();
        }
        int incSum = a[0], excSum = 0;
        for (int i = 1; i < n; i++) {
            int currIncSum = excSum + a[i];
            int currExcSum = Math.max(incSum, excSum);
            incSum = currIncSum;
            excSum = currExcSum;
        }
        System.out.println(Math.max(incSum, excSum));
    }
}
