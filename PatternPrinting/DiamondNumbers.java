package PatternPrinting;

import java.util.Scanner;

public class DiamondNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sp = n/2, star = 1;
        int value = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sp; j > 0; j --) {
                System.out.print("\t");
            }
            int val = value;
            for (int j = 1; j <= star; j ++) {
                System.out.print(val + "\t");
                if (j <= star/2) val ++;
                else val --;
            }
            if (i <= n/2) {
                sp --;
                star += 2;
                value ++;
            } else {
                sp ++;
                star -= 2;
                value --;
            }
            System.out.println();
        }
    }
}
