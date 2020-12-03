package PatternPrinting;

import java.util.Scanner;

public class HourGlass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sp = 0, star = n;
        for (int i = 1; i <= n; i++) {
            for (int j = sp; j > 0; j --) {
                System.out.print("\t");
            }
            for (int j = star; j > 0; j --) {
                if (i <= n/2 && i != 1 && j != 1 && j != star) {
                    System.out.print("\t");
                }
                else {
                    System.out.print("*\t");
                }
            }
            if (i <= n/2)
            {
                sp ++;
                star-=2;
            }
            else{
                sp --;
                star+= 2;
            }
            System.out.println();
        }
    }
}
