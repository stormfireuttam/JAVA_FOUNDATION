package TwoDimArrray;

import java.util.Scanner;

public class WaveTraversal2dArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m and n of 2d array: ");
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter array elements: ");
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Wave Traversal Output: ");
        int col = 0;
        while (col< n){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i][col] + " ");
            }
            col ++;
            if (col < n) {
                for (int i = m - 1; i >= 0; i --) {
                    System.out.print(arr[i][col] + " ");
                }
                col ++;
            }
            else {
                break;
            }
        }
    }
}
