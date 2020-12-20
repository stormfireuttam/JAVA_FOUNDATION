package DynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int values[] = new int[n];
        int weights[] = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        int capacity = scanner.nextInt();
        int dp[][] = new int[n+1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j ++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= weights[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                    }
                }
            }
        }
        System.out.println(dp[n][capacity]);
    }
}
