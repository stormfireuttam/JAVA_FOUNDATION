package PatternPrinting;

import java.util.Scanner;

public class DiagonalPrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println("*");
        }
        for (int i = n - 1; i >= 0; i --) {
            for (int j = 0; j < i; j++) {
                System.out.print("\t");
            }
            System.out.println("*");
        }
    }
}
