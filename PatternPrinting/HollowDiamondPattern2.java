package PatternPrinting;

import java.util.Scanner;

public class HollowDiamondPattern2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int innerSpace = -1, outerSpace = n/2;
        for (int i = 1; i <= n; i++) {
            for (int j = outerSpace; j > 0; j --) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            if (innerSpace > 0) {
                for (int j = innerSpace; j > 0; j --) {
                    System.out.print("\t");
                }
                System.out.println("*");
            }
            System.out.println();
            if (i <= n / 2) {
                outerSpace --;
                innerSpace += 2;
            } else {
                outerSpace ++;
                innerSpace -= 2;
            }
        }
    }
}
