package DynamicProgramming;

import java.util.Scanner;

public class CoinChangePermutations {
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
        for (int amt = 1; amt <= target; amt++) {
            for(int coin : coins) {
                if (coin <= amt) {
                    dp[amt] += dp[amt - coin];
                }
            }
        }
        System.out.println(dp[target]);
    }
}
