package PatternPrinting;

import java.util.Scanner;

public class DiamondPattern {

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            // write ur code here
            int n = scn.nextInt();
            int stars = 1, space = n/2;
            for(int i = 1; i <= n; i ++) {
                for(int j = space; j > 0; j --)
                    System.out.print("\t");
                for(int j = stars; j > 0; j --)
                    System.out.print("*\t");
                System.out.println();
                if(i <= n/2) {
                    stars += 2;
                    space --;
                }
                else {
                    stars -= 2;
                    space ++;
                }
            }

        }
}
