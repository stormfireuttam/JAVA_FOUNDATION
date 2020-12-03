package PatternPrinting;

import java.util.Scanner;

public class NumberPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sp = n - 1;
        for (int i = 1; i <= n; i++) {
//            int currVal = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            for (int j = 1; j < 2 * sp; j++) {
                System.out.print("\t");
            }
            if (i != n) {
                for (int j = i; j > 0; j--) {
                    System.out.print(j + "\t");
                }
            }
            else
            {
                for (int j = i - 1; j > 0; j--) {
                    System.out.print(j + "\t");
                }
            }
            sp --;
            System.out.println();
        }
    }
}
