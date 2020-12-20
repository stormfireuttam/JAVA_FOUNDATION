package DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int values[] = new int[n];
        int weights[] = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        int dp[] = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = weights[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }
        System.out.println(dp[capacity]);
    }
}
