package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int dpp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            dpp[i][m - 1] = a[i][m - 1];
        }
        for (int j = m - 2; j >= 0; j --) {
            for (int i = n - 1; i >= 0; i --) {
                if (i == 0) {
                    dpp[i][j] = a[i][j] + Math.max(dpp[i][j + 1], dpp[i + 1][j + 1]);
                } else if(i == n - 1) {
                    dpp[i][j] = a[i][j] + Math.max(dpp[i][j + 1], dpp[i - 1][j + 1]);
                } else {
                    dpp[i][j] = a[i][j] + Math.max(dpp[i][j + 1],
                            Math.max(dpp[i-1][j+1], dpp[i+1][j+1]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dpp[i][0], max);
        }
        System.out.println(max);
    }
}
