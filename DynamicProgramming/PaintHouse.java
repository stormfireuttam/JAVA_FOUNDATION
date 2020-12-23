/*
1. You are given a number n, representing the number of houses.
2. In the next n rows,
    you are given 3 space separated numbers representing the cost of painting
    nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of
    painting all houses without painting any consecutive house with same color.
 */
package DynamicProgramming;

import java.util.Scanner;

public class PaintHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rCost[] = new int[n];
        int bCost[] = new int[n];
        int gCost[] = new int[n];

        for (int i = 0; i < n; i++) {
            rCost[i] = scanner.nextInt();
            bCost[i] = scanner.nextInt();
            gCost[i] = scanner.nextInt();
        }

        int redMinCost = rCost[0];
        int blueMinCost = bCost[0];
        int greenMinCost = gCost[0];

        for (int i = 1; i < n; i++) {
            int currRCost = Math.min(blueMinCost, greenMinCost) + rCost[i];
            int currBCost = Math.min(redMinCost, greenMinCost) + bCost[i];
            int currGCost = Math.min(redMinCost, blueMinCost) + gCost[i];

            redMinCost = currRCost;
            blueMinCost = currBCost;
            greenMinCost = currGCost;
        }

        System.out.println(Math.min(redMinCost, Math.min(greenMinCost, blueMinCost)));
    }
}
