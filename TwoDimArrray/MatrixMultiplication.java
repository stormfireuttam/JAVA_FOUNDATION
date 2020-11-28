package TwoDimArrray;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1, n1, m2, n2;
        System.out.println("Enter m and n of 1st 2d Array: ");
        m1 = Integer.parseInt(scanner.nextLine());
        n1 = Integer.parseInt(scanner.nextLine());
        int a[][] = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                a[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Enter m and n of 1st 2d Array: ");
        m2 = Integer.parseInt(scanner.nextLine());
        n2 = Integer.parseInt(scanner.nextLine());
        int b[][] = new int[m2][n2];
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                b[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        if (n1 != m2) {
            System.out.println("Invalid Input");
        }
        else {
            int product[][] = new int[m1][n2];
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    int sum = 0;
                    for (int k = 0; k < n1; k++) {
                        sum += a[i][k] * b[k][j];
                    }
                    product[i][j] = sum;
                }
            }
            System.out.println("Product: ");
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    System.out.print(product[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
}
