package DynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[target]);
    }
}
