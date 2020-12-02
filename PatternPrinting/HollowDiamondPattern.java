package PatternPrinting;

import java.util.Scanner;

public class HollowDiamondPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int space = n/2, star = n/2 + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = star; j > 0; j --) {
                System.out.print("*\t");
            }
            for (int j = space; j > 0; j --) {
                System.out.print("\t");
            }
            for (int j = star; j > 0; j --) {
                System.out.print("*\t");
            }
            if (i <= n/2) {
                space += 2;
                star --;
            }
            else {
                space -= 2;
                star ++;
            }
            System.out.println();
        }
    }
}
