package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairsWithJumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int cp = countPaths(arr, n);
        System.out.println(cp);
    }
    private static int countPaths(int[] arr, int n) {
        int dp[] = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i --) {
            int paths = 0;
            for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                paths += dp[i + j];
            }
            dp[i] = paths;
        }
        return dp[0];
    }
}
