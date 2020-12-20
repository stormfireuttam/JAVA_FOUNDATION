package DynamicProgramming;

import java.util.Scanner;

public class MinimumCost {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int dpp[][] = new int[n][m];
        dpp[n - 1][m - 1] = arr[n - 1][m - 1];
        for (int i = n - 1; i >= 0; i --) {
            for (int j = m - 1; j >= 0; j --) {
                if (i == n - 1 && j == m - 1)
                    continue;
                if (i == n - 1){
                    dpp[i][j] = arr[i][j] + dpp[i][j + 1];
                }
                else if (j == m - 1) {
                    dpp[i][j] = arr[i][j] + dpp[i + 1][j];
                }
                else {
                    dpp[i][j] = arr[i][j] + Math.min(dpp[i + 1][j], dpp[i][j + 1]);
                }
            }
        }
        System.out.println(dpp[0][0]);
    }
}
