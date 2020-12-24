package DynamicProgramming;

import java.util.Scanner;

public class DivideNLengthIntoKSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == 0 || k == 0 || n < k) {
            System.out.println(0);
            return;
        }
        /*
            In this problem we need to divide the number of people n into k teams
            So their are some base cases to be considered first of all
            a) if n < k  that is number of teams is greater than number of people return 0
            b) if n == k when number of teams is equal to the number of people return a 1
            c) if n > k it is area where we start solving the problem for which we need to formulate a formula
            d) if k == 0 or n == 0 return 0

            Now lets have a look at the problem in our hand when n > k
            So,  what would be the formula for it
            Lets see...
            at a particular position in dp[i][j] where i denotes the number of teams and j denotes the number of people
            dp[i][j] = k * dp[i][j - 1] + dp[i - 1][j - 1]
         */
        int dp[][] = new int[k + 1][n + 1];
        for (int teams = 1; teams <= k; teams++) {
            for (int numberOfPeople = 1; numberOfPeople <= n; numberOfPeople++) {
                if (teams == numberOfPeople) {
                    dp[teams][numberOfPeople] = 1;
                }
                else if (numberOfPeople > teams) {
                    dp[teams][numberOfPeople] = teams * dp[teams][numberOfPeople - 1] + dp[teams - 1][numberOfPeople - 1];
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
