package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairsWithMinMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Integer dp[] = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n; i >= 0; i --) {
            int min = Integer.MAX_VALUE;
            if (arr[i] != 0) {
                for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                    if (dp[i + j] != null)
                        min = Math.min(min, dp[i + j]);
                }
                if (min != Integer.MAX_VALUE)
                    dp[i] = min + 1;
            }
        }
        System.out.println(dp[0]);
    }
}
