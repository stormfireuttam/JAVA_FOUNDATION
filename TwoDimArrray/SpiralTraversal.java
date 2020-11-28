package TwoDimArrray;

import java.util.Scanner;

public class SpiralTraversal {
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
        System.out.println("Spiral Traversal: ");
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(arr[i][colStart] + " ");
            }
            colStart++;
            for (int i = colStart; i <= colEnd; i ++) {
                System.out.print(arr[rowEnd][i] + " ");
            }
            rowEnd --;
            for (int i = rowEnd; i >= rowStart; i --) {
                System.out.print(arr[i][colEnd] + " ");
            }
            colEnd --;
            for (int i = colEnd; i >= colStart ; i --) {
                System.out.print(arr[rowStart][i] + " ");
            }
            rowStart ++;
         }
    }
}
