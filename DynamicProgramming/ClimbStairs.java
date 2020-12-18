package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cp = countPaths (n, new int[n + 1]);
        System.out.println(cp);
        System.out.println(countPathsTab(n));
    }
    // Recursive Memoization approach for counting Paths using Dynamic Programming Approach
    public static int countPaths(int n, int []qb){
        if (n == 0) {
            return 1;
        }
        else if(n < 0) {
            return 0;
        }
        if (qb[0] != 0) {
            return qb[n];
        }
        int path1 = countPaths(n - 1, qb);
        int path2 = countPaths(n - 2, qb);
        int path3 = countPaths(n - 3, qb);
        int totalPaths = path1 + path2 + path3;
        qb[n] = totalPaths;
        return qb[n];
    }
    // Tabulation approach
    public static int countPathsTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1){
                dp[i] = dp[i - 1];
            }
            else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
}
